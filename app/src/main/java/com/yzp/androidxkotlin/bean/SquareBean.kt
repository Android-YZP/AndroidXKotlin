package com.yzp.androidxkotlin.bean



data class SquareBean(
    val curPage: Double,
    val datas: List<DataY>,
    val offset: Double,
    val over: Boolean,
    val pageCount: Double,
    val size: Double,
    val total: Double
)

data class DataY(
    val apkLink: String,
    val audit: Double,
    val author: String,
    val canEdit: Boolean,
    val chapterId: Double,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Double,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val id: Double,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Double,
    val realSuperChapterId: Double,
    val selfVisible: Double,
    val shareDate: Double,
    val shareUser: String,
    val superChapterId: Double,
    val superChapterName: String,
    val tags: List<Any>,
    val title: String,
    val type: Double,
    val userId: Double,
    val visible: Double,
    val zan: Double
)