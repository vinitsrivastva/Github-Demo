package com.demoapp.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import com.demoapp.R
import com.demoapp.main.App
import com.demoapp.model.RepoData
import com.demoapp.util.Constants
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_layout.*
import javax.inject.Inject

class ItemDetailFragment : Fragment() , ItemDetailMVP.View{

    @Inject
    lateinit var presenter: ItemDetailMVP.Presenter
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.getApplication() as App)
                .getAppComponent()!!
                .itemDetailComponent(ItemDetailModule(this))
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_detail, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        presenter.init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }


    override fun populateData() {

        val repoData: RepoData = activity!!.getIntent().getParcelableExtra(Constants.ITEM_DETAIL)
        txtPostDesc.setText(repoData.description)
        txtAuthor.setText(repoData.author)
        txtName.setText(repoData.name)
        txtStars.setText(repoData.stars + " Stars")
        txtStarsToday.setText(repoData.currentPeriodStars + " stars today")
        txtForks.setText(repoData.forks + " Forks")
        txtLanguage.setText(repoData.language)
        webView.settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING)
        webView.settings.setSupportZoom(true)
        webView.settings.setBuiltInZoomControls(true)
        webView.settings.setDisplayZoomControls(false)
        var readmeURL = Constants.GITHUB_CONTENT_URL + repoData.author + "/" + repoData.name + "/master/README.md"
        webView.loadUrl(readmeURL)

    }


}