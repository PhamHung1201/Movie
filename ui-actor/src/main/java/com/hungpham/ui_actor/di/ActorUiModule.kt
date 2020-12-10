package com.hungpham.ui_actor.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardKey
import com.hungpham.card_kit.CardType
import com.hungpham.image_support.ImageDownloader
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_actor.ActorAdapter
import com.hungpham.ui_actor.ActorCard
import com.hungpham.ui_actor.data.ActorDataSource
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module
object ActorUiModule {

    @Provides
    @IntoSet
    fun provideActorCard(actorAdapter: Lazy<ActorAdapter>): Card {
        return ActorCard(actorAdapter)
    }

    @Provides
    @IntoMap
    @CardKey(CardType.ACTOR)
    fun provideActorDataSource(movieProvider: MovieProvider): CardDataProvider {
        return ActorDataSource(movieProvider)
    }

    @Provides
    fun provideActorAdapter(imageDownloader: ImageDownloader): ActorAdapter {
        return ActorAdapter(imageDownloader)
    }
}