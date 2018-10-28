package com.demoapp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.demoapp.BaseActivity
import com.demoapp.R
import com.demoapp.model.RepoData
import com.demoapp.ui.web.WebViewActivity
import com.demoapp.util.Constants

class ItemDetailActivity : BaseActivity() {

    private lateinit var repoData: RepoData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        repoData = getIntent().getParcelableExtra(Constants.ITEM_DETAIL)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_info, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if (id == R.id.action_info) {

            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", repoData.url)
            startActivity(intent)
            return true

        }

        return super.onOptionsItemSelected(item)

    }
}

