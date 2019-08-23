package com.github.tonydeng.openc2.utilities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author dengtao
 **/
class OpenC2MapTest {
    private val MAP1_KEY = "key1"
    private val MAP2_KEY = "key2"
    private val MAP3_KEY = "key3"
    private val MAP1_VALUE = "value1"
    private val MAP2_VALUE = "value2"
    private val MAP3_VALUE = "value3"


    @Test
    fun test() {
        val mapObject = OpenC2Map("String") // Generic map

        mapObject.put(MAP1_KEY, MAP1_VALUE)
                .put(MAP2_KEY, MAP2_VALUE)
                .put(MAP3_KEY, MAP3_VALUE)

        assertEquals("String", mapObject.getObjectType())
        assertEquals(Keys.ARGUMENTS, mapObject.getSectionType())
        val map = mapObject.getAll()
        assertEquals(MAP1_VALUE, map[MAP1_KEY])
        assertEquals(MAP2_VALUE, map[MAP2_KEY])
        assertEquals(MAP3_VALUE, map[MAP3_KEY])
        assertEquals(MAP1_VALUE, mapObject.get(MAP1_KEY))
        assertEquals(MAP2_VALUE, mapObject.get(MAP2_KEY))
        assertEquals(MAP3_VALUE, mapObject.get(MAP3_KEY))
        assertEquals(3, mapObject.size())
        assertEquals(MAP1_VALUE, mapObject.remove(MAP1_KEY))
        assertEquals(MAP2_VALUE, mapObject.remove(MAP2_KEY))
        assertEquals(MAP3_VALUE, mapObject.remove(MAP3_KEY))

        assertNotNull(mapObject.hashCode())

        val mapObject2 = OpenC2Map("String")  // Generic map
        val mapObject3 = OpenC2Map("String")  // Generic map

        mapObject2.put(MAP1_KEY, MAP1_VALUE)
                .put(MAP2_KEY, MAP2_VALUE)
                .put(MAP3_KEY, MAP3_VALUE)
        mapObject3.put(MAP1_KEY, MAP1_VALUE)
                .put(MAP2_KEY, MAP2_VALUE)

        assertTrue(mapObject == mapObject)
        assertFalse(mapObject == mapObject2)
        assertFalse(mapObject == mapObject3)
    }

}