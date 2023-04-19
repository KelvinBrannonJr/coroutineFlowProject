package k.brannon.coroutineflowproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import k.brannon.coroutineflowproject.model.NewsRepository

class ListViewModel: ViewModel() {
    val newsArticles = NewsRepository().getNewsArticles().asLiveData()
}