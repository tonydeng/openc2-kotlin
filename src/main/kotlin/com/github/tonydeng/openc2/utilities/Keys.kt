package com.github.tonydeng.openc2.utilities

/**
 * The Keys class contains a list of static strings that are used to set the key portion of
 * key/value pairs that are pushed to the various sections of OpenC2 message.  This is done so if
 * values change for given keys as the spec matures, only need to change one class.
 *
 * @author Tony Deng
 * @version V1.0
 * @date 2019-08-17 23:21
 */
object Keys {

    /**
     * Main message keys
     */
    val HEADER = "header"
    val BODY = "command"
    val RESPONSE = "response"
    val ID = "id"
    val ACTION = "action"
    val TARGET = "target"
    val ACTUATOR = "actuator"
    val ARGUMENTS = "args"

    /**
     * Subsection keys
     */
    val NAME = "name"
    val PATH = "path"
    val HASHES = "hashes"

    val TYPE = "type"
    val VALUE = "value"
    val RESOLVES_TO_REFS = "resolves_to_refs"
    val BELONGS_TO_REFS = "belongs_to_refs"
    val MIME_TYPE = "mime_type"
    val PAYLOAD_BIN = "payload_bin"
    val URL = "url"
    val DXL_TOPIC = "dxl_topic"
    val ACTUATOR_ID = "actuator_id"
}
