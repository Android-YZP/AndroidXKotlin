package com.yzp.androidxkotlin.kotlin


data class TestBean(
    val code: Int,
    val `data`: Data,
    val msg: String
)

data class Data(
    val current: Double,
    val hitCount: Boolean,
    val optimizeCountSql: Boolean,
    val orders: List<Any>,
    val pages: Double,
    val records: List<Record>,
    val searchCount: Boolean,
    val size: Double,
    val total: Double
)

data class Record(
    val createAt: String,
    val externalCode: String,
    val outboundReceiptCode: String,
    val pickingUser: String,
    val status: String,
    val statusName: String,
    val type: String,
    val typeName: String
)