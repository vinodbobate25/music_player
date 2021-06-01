package com.apps.musicplayerapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize



@Entity(tableName = "CurrentMusic")
data class Music(

	@ColumnInfo(name="artist")
	val artist: String? = null,

	@ColumnInfo(name="album")
	val album: String? = null,

	@ColumnInfo(name="image_url")
	val imageUrl: String? = null,

	@ColumnInfo(name="preview_url")
	val previewUrl: String? = null,

	@ColumnInfo(name="name")
	val name: String? = null,

	@ColumnInfo(name="link_url")
	val linkUrl: String? = null,

	@ColumnInfo(name="played_at")
	val playedAt: String? = null,

	@ColumnInfo(name="sid")
	val sid: String? = null,
	@PrimaryKey(autoGenerate = true)
	val id: Int
)
