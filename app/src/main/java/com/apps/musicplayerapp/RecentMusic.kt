package com.apps.musicplayerapp


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "RecentMusic")
data class RecentMusic(

	@ColumnInfo(name="artist")
	@SerializedName("artist")
	val artist: String? = null,

	@ColumnInfo(name="album")
	@SerializedName("album")
	val album: String? = null,

	@ColumnInfo(name="image_url")
	@SerializedName("image_url")
	val imageUrl: String? = null,

	@ColumnInfo(name="preview_url")
	@SerializedName("preview_url")
	val previewUrl: String? = null,

	@ColumnInfo(name="name")
	@SerializedName("name")
	val name: String? = null,

	@ColumnInfo(name="link_url")
	@SerializedName("link_url")
	val linkUrl: String? = null,

	@ColumnInfo(name="played_at")
	@SerializedName("played_at")
	val playedAt: String? = null,

	@ColumnInfo(name="sid")
	@SerializedName("sid")
	val sid: String? = null,
	@PrimaryKey(autoGenerate = true)
	val id: Int
)
