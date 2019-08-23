package com.github.tonydeng.openc2.utilities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.github.tonydeng.openc2.actuators.ActuatorType
import com.github.tonydeng.openc2.targets.TargetType
import com.google.common.collect.Maps

/**
 * @author dengtao
 **/
class OpenC2Map<T> {
    private var sectionType: String
    private var objectType: String
    var map: MutableMap<String, Any>

    /**
     * Constructor for creating a OpenC2Map object for a given type
     *
     * @param type The class type to assign to the object
     */
    constructor(type: T) {
        this.sectionType = convertType(type)
        this.objectType = type.toString()
        map = Maps.newHashMap()
    }

    /**
     * Helper method to convert the type object into it's section field name for the JSON
     */
    private fun convertType(type: T): String {
        if (type is TargetType) {
            return Keys.TARGET
        }
        return if (type is ActuatorType) {
            Keys.ACTUATOR
        } else Keys.ARGUMENTS
    }

    /**
     * Put a key/value into the OpenC2 map object
     *
     * @param key   the key for the JSON message
     * @param value The value object to assign to the key in the JSON message
     * @return the OpenC2Map object so users can method chain puts
     */
    fun put(key: String, value: Any): OpenC2Map<T> {
        map[key] = value
        return this
    }

    /**
     * Get a value from the OpenC2 map object based on a key
     *
     * @param key Key to lookup in the map.
     * @return Object value assigned to the key
     */
    operator fun get(key: String): Any? {
        return map[key]
    }

    /**
     * Remove a give value from the map based on the key
     *
     * @param key Key to remove from the map
     * @return Object value assigned to the key
     */
    fun remove(key: String): Any? {
        val value = get(key)
        map.remove(value)
        return value
    }

    /**
     * Get the size of the internal map
     *
     * @return number of elements in the map
     */
    fun size(): Int {
        return map.size
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(obj: Any?): Boolean {
        return super.equals(obj)
    }

    /**
     * Get the section this map represents (target, actuator, args)
     *
     * @return String representing the section identifier
     */
    @JsonIgnore
    fun getSectionType(): String {
        return sectionType
    }

    /**
     * Get the object type the map represents. i.e. ip-addr target object
     *
     * @return String representing the object identifier for this object
     */
    @JsonIgnore
    fun getObjectType(): String {
        return objectType
    }

    /**
     * Get the whole hashmap of key/value pairs
     *
     * @return Map object of all attributes assigned
     */
    @JsonIgnore
    fun getAll(): Map<String, Any> {
        return map
    }
}
