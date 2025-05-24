package com.example.taskamazing.datalayer.mapper

import android.view.Display.Mode
import com.example.taskamazing.datalayer.entity.User
import com.example.taskamazing.domainmodel.ModelUser

fun User.toDomain(): ModelUser{
    return ModelUser(
        userId = this.userId,
        createdAt = this.createdAt,
        email = this.email,
        displayName = this.displayName
    )
}

fun ModelUser.toEntity(): User{
    return User(
        userId = this.userId,
        createdAt = this.createdAt,
        email = this.email,
        displayName = this.displayName
    )
}