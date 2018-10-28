package com.demoapp.ui.list

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import com.demoapp.model.RepoData


class ListActivityPresenter(private var model: ListActivityMVP.Model): ListActivityMVP.Presenter  {

    private lateinit var view: ListActivityMVP.View
    private var subscription = CompositeDisposable()


    override fun setView(view: ListActivityMVP.View) {

        this.view = view
    }

    override fun loadData(data: HashMap<String, String>) {

        subscription.add(model
                .result(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<List<RepoData>>() {

                    override fun onComplete() {
                    }

                    override fun onStart() {

                        if (view != null) {
                            view.clearData()
                            view.showProgress(true)
                        }
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        if (view != null) {
                            view.showMessage("Error getting data")
                        }
                    }
                    override fun onNext(repoData: List<RepoData>) {
                        if (view != null) {
                            view.updateData(repoData)
                            view.showProgress(false)
                            view.showMessage("Showing " + data.get("since") + " trending github repo")
                        }
                    }
                }))

    }

    override fun unsubscribe() {

        if (subscription != null){
            if(!subscription.isDisposed){
                subscription.dispose()
            }
        }
    }

}