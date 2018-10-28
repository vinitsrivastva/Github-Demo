package com.demoapp.ui.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.demoapp.BaseFragment
import com.demoapp.R
import com.demoapp.adapter.ListAdapter
import com.demoapp.main.App
import com.demoapp.model.RepoData
import com.demoapp.ui.detail.ItemDetailActivity
import com.demoapp.util.Constants
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ItemListFragment: BaseFragment(), ListActivityMVP.View {

    @Inject lateinit var presenter: ListActivityMVP.Presenter

    private lateinit var rootView: View
    lateinit var listAdapter: ListAdapter
    var postList = mutableListOf<RepoData>()
    val data = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.getApplication() as App)
                .getAppComponent()!!
                .itemListComponent(ListActivityModule(this))
                .inject(this)


        listAdapter = ListAdapter(requireContext() , postList , this , this )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        initView()
    }

    private fun initView(){

        recyclerView.addItemDecoration(DividerItemDecoration(activity , DividerItemDecoration.VERTICAL))
        recyclerView.setLayoutManager(LinearLayoutManager(activity))
        recyclerView.adapter = listAdapter

        data.put("since", "daily")  // other param to use : monthly/weekely
        presenter.loadData(data)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    override fun updateData(repoData: List<RepoData>) {
        postList.addAll(repoData)
        listAdapter.notifyDataSetChanged()
    }

    override fun showProgress(show: Boolean) {

        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE

        }
    }

    override fun showMessage(msg: String) {
        Toast.makeText(activity , msg , Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(result: RepoData) {

        val intent = Intent(activity, ItemDetailActivity::class.java)
        intent.putExtra(Constants.ITEM_DETAIL, result)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_daily -> {
                data.put("since", "daily")
                presenter.loadData(data)
            }
            R.id.action_weekly -> {
                data.put("since", "weekly")
                presenter.loadData(data)
            }
            R.id.action_monthly -> {
                data.put("since", "monthly")
                presenter.loadData(data)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun clearData() {
        postList.clear()
        listAdapter.notifyDataSetChanged()
    }
}
