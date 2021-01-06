package com.plcoding.spotifycloneyt.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.plcoding.spotifycloneyt.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

// provides dependencies that lives as long as the app lives
@Module
// scope the life time of the dependencies (here is as long as the app lives so ApplicationComponent)
@InstallIn(ApplicationComponent::class)
object AppModule {

    // we will not ever call this function
    // dagger hilt uses this fun to construct Glide instance
    @Singleton // singleton Glide dependency
    @Provides
    fun provideGlideInstance(@ApplicationContext context: Context) =
        Glide.with(context).setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.ic_image)
                .error(R.drawable.ic_image)
                // caching the image with glide
                .diskCacheStrategy(DiskCacheStrategy.DATA)
        )

}