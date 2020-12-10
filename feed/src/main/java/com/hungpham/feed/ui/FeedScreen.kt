package com.hungpham.feed.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.app_utils.extract_parents.ParentHost
import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.recycler.DelegationAdapter
import com.hungpham.feed.R
import com.hungpham.feed.di.DaggerFeedComponent
import com.hungpham.feed.di.FeedDependencies
import com.hungpham.feed.presenter.FeedPresenter
import javax.inject.Inject

class FeedScreen : Fragment(), FeedView {

    @Inject
    lateinit var delegationAdapter: DelegationAdapter

    @Inject
    lateinit var presenter: FeedPresenter

    private lateinit var rvFeed: RecyclerView

    companion object {
        fun newInstance(): FeedScreen {
            return FeedScreen()
        }
    }

    override fun onAttach(context: Context) {
        setupDi()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFeed = view.findViewById(R.id.rvFeed)

        delegationAdapter.init()

        rvFeed.run {
            adapter = delegationAdapter
            layoutManager = LinearLayoutManager(this@FeedScreen.context)
        }

        presenter.fetchData()
    }

    override fun updateItems(item: CardItem) {
        this.delegationAdapter.setItem(item)
    }

    private fun setupDi() {
        DaggerFeedComponent.builder()
            .bindDependencies(
                (requireContext().applicationContext as ParentHost).extractParent(
                    FeedDependencies::class
                ) as FeedDependencies
            )
            .bindView(this)
            .context(requireContext())
            .build()
            .inject(this)
    }
}