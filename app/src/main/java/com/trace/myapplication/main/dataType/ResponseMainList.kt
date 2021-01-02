package com.trace.myapplication.main.dataType

data class ResponseMainList(
        val code : Int,
        val success : Boolean,
        val msg : String,
        val data : SomeData?
)

data class SomeData(
        val content: List<contentData>,
        val pageable : SomePageData?,
        val last: Boolean,
        val totalElements: Int,
        val totalPages: Int,
        val size: Int,
        val number: Int,
        val sort: sortData?,
        val numberOfElements: Int,
        val first: Boolean,
        val empty: Boolean
)

data class SomePageData(
        val sort: sortData?,
        val offset: Int,
        val pageNumber: Int,
        val pageSize: Int,
        val paged: Boolean,
        val unpaged: Boolean
)
data class sortData(
        val sorted: Boolean,
        val unsorted: Boolean,
        val empty: Boolean
)

data class contentData(
        val id: Int,
        val location: String,
        val address: String,
        val lotNumber: String,
        val oneRoomPrice: Int,
        val completionDate: String
)