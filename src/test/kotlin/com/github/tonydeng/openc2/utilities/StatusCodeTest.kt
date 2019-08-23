package com.github.tonydeng.openc2.utilities

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.tonydeng.openc2.utilities.StatusCode.OK
import net.cloudopt.logger.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author dengtao
 **/
class StatusCodeTest {
    private val log = Logger.getLogger(StatusCodeTest::class.java)
    private val mapper = jacksonObjectMapper()
    @Test
    fun testGetType() {
        assertEquals(200, OK.value)
        assertEquals("200", OK.toString())
        assertEquals("OK", OK.name)
    }

    @Test
    fun testToJson() {
        assertEquals("200", OK.toString())
        assertEquals("\"OK\"", mapper.writeValueAsString(OK))
        log.info("{}", mapper.writeValueAsString(OK))
    }
}


