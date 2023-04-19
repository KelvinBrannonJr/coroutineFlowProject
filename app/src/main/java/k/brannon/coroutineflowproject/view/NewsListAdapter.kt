package k.brannon.coroutineflowproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import k.brannon.coroutineflowproject.databinding.ItemNewsArticleBinding
import k.brannon.coroutineflowproject.model.NewsArticle

class NewsListAdapter: RecyclerView.Adapter<NewsListAdapter.NewsItemViewHolder>() {
    private var binding: ItemNewsArticleBinding? = null

    private val newsItems = arrayListOf<NewsArticle>()

    fun onAddNewsItem(item: NewsArticle) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsItemViewHolder {
        binding = ItemNewsArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsItemViewHolder(binding!!.root)
    }

    override fun getItemCount() = newsItems.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    inner class NewsItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val viewBinding = binding
        private val imageView = binding?.newsImage
        private val author = binding?.newsAuthor
        private val title = binding?.newsTitle
        private val publishedAt = binding?.newsPublishedAt

        fun bind(newsItem: NewsArticle) {
            imageView?.loadImage(newsItem.urlToImage)
            author?.text = newsItem.author
            title?.text = newsItem.title
            publishedAt?.text = newsItem.publishedAt
        }
    }

}