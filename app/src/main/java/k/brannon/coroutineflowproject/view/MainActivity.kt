package k.brannon.coroutineflowproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import k.brannon.coroutineflowproject.databinding.ActivityMainBinding
import k.brannon.coroutineflowproject.model.NewsArticle
import k.brannon.coroutineflowproject.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    lateinit var viewModel: ListViewModel
    private val newsListAdapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        viewModel = ViewModelProviders.of(this)[ListViewModel::class.java]

        binding?.newsList?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.newsArticles.observe(this, Observer { article ->
            binding?.loadingView?.visibility = View.GONE
            binding?.newsList?.visibility = View.VISIBLE
            newsListAdapter.onAddNewsItem(article)
            binding?.newsList?.smoothScrollToPosition(0)
        })
    }
}