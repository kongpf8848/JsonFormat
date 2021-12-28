package io.github.kongpf8848.jsonformat.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static String formatJson(String jsonStr) throws JsonProcessingException {
        return Holder.MAPPER.writer(Holder.DEFAULT_PRETTY_PRINTER).writeValueAsString(Holder.MAPPER.readValue(jsonStr, Object.class));
    }

    public static String minifyJson(String jsonStr) throws JsonProcessingException {
        return Holder.MAPPER.writeValueAsString(Holder.MAPPER.readValue(jsonStr, Object.class));
    }

    public static void verifyJson(String jsonStr) throws JsonProcessingException {
        Holder.MAPPER.readValue(jsonStr, Object.class);
    }

    public static final class Holder {
        public static final ObjectMapper MAPPER = new ObjectMapper();
        public static final DefaultPrettyPrinter DEFAULT_PRETTY_PRINTER = new CustomPrettyPrinter();

        private Holder() {
        }
    }

    private static final class CustomPrettyPrinter extends DefaultPrettyPrinter {
        private static final DefaultIndenter UNIX_LINE_FEED_INSTANCE = new DefaultIndenter("  ", "\n");

        public CustomPrettyPrinter() {
            this._objectFieldValueSeparatorWithSpaces = ": ";
            this._objectIndenter = UNIX_LINE_FEED_INSTANCE;
            this._arrayIndenter = UNIX_LINE_FEED_INSTANCE;
        }

        public DefaultPrettyPrinter createInstance() {
            return new CustomPrettyPrinter();
        }
    }
}
