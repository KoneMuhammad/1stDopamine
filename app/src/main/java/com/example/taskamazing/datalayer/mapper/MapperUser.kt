package com.example.taskamazing.datalayer.mapper

import android.view.Display.Mode
import com.example.taskamazing.datalayer.entity.User
import com.example.taskamazing.datalayer.domainmodel.ModelUser

fun User.toDomain(): ModelUser {
    return ModelUser(
        id = this.id,
        created_at = this.created_at,
        email = this.email,
        display_name = this.display_name
    )
}

fun ModelUser.toEntity(): User{
    return User(
        id = this.id,
        created_at = this.created_at,
        email = this.email,
        display_name = this.display_name
    )
}