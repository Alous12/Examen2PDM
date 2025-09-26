package com.calyrsoft.ucbp1.features.profile.data.repository

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Name
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.PathUrl
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.PhoneNumber
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.Summary
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository

class ProfileRepository: IProfileRepository {
    override fun fetchData(): Result<ProfileModel> {
        return Result.success(
            ProfileModel(
                name = Name.create("Homero J. Simpson"),
                email = Email.create("homero.simpson@springfieldmail.com"),
                cellphone = PhoneNumber.create("+1 (939) 555‑7422"),
                pathUrl = PathUrl.create("https://www.viaempresa.cat/uploads/s1/43/99/69/homer.jpg"),
                summary = Summary.create("Ciudadano de Springfield y dedicado inspector de seguridad en la Planta Nuclear.")
            )
        )
    }
}