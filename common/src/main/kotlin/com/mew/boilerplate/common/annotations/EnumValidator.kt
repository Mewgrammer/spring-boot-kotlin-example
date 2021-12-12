package com.mew.boilerplate.common.annotations

import java.util.*
import javax.validation.*
import javax.validation.constraints.NotNull
import kotlin.collections.ArrayList
import kotlin.reflect.KClass


@Constraint(validatedBy = [EnumValidatorImpl::class])
@Target(AnnotationTarget.FIELD)
@MustBeDocumented
@NotNull
@ReportAsSingleViolation
annotation class IsEnum(
    val enumClazz: KClass<out Enum<*>>,
    val message: String = "provided value is not a valid enum value",
)

class EnumValidatorImpl : ConstraintValidator<IsEnum, String> {
    private val valueList: MutableList<String> = ArrayList()

    override fun isValid(value: String, context: ConstraintValidatorContext): Boolean {
        return valueList.contains(value.uppercase(Locale.getDefault()))
    }

    override fun initialize(constraintAnnotation: IsEnum) {
        val enumClass: KClass<out Enum<*>> = constraintAnnotation.enumClazz
        val enumValArr = enumClass.java.enumConstants
        for (enumVal in enumValArr) {
            valueList.add(enumVal.toString().uppercase(Locale.getDefault()))
        }
    }
}