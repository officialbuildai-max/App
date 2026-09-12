package com.amazonaws.util.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;

/* loaded from: classes2.dex */
final class GsonFactory implements AwsJsonFactory {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.util.json.GsonFactory$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19106a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f19106a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19106a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19106a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19106a[JsonToken.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19106a[JsonToken.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19106a[JsonToken.BOOLEAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19106a[JsonToken.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19106a[JsonToken.NULL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19106a[JsonToken.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19106a[JsonToken.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class GsonReader implements AwsJsonReader {

        /* renamed from: a, reason: collision with root package name */
        private final JsonReader f19107a;

        public GsonReader(Reader reader) {
            this.f19107a = new JsonReader(reader);
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void a() {
            this.f19107a.beginObject();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void b() {
            this.f19107a.endObject();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void c() {
            this.f19107a.skipValue();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void close() {
            this.f19107a.close();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public boolean d() {
            JsonToken peek = this.f19107a.peek();
            return JsonToken.BEGIN_ARRAY.equals(peek) || JsonToken.BEGIN_OBJECT.equals(peek);
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public String e() {
            return this.f19107a.nextName();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public String f() {
            JsonToken peek = this.f19107a.peek();
            if (!JsonToken.NULL.equals(peek)) {
                return JsonToken.BOOLEAN.equals(peek) ? this.f19107a.nextBoolean() ? "true" : "false" : this.f19107a.nextString();
            }
            this.f19107a.nextNull();
            return null;
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public boolean hasNext() {
            return this.f19107a.hasNext();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public AwsJsonToken peek() {
            try {
                return GsonFactory.d(this.f19107a.peek());
            } catch (EOFException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class GsonWriter implements AwsJsonWriter {

        /* renamed from: a, reason: collision with root package name */
        private final JsonWriter f19108a;

        public GsonWriter(Writer writer) {
            this.f19108a = new JsonWriter(writer);
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter a() {
            this.f19108a.beginObject();
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter b() {
            this.f19108a.endObject();
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter c(String str) {
            this.f19108a.name(str);
            return this;
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public void close() {
            this.f19108a.close();
        }

        @Override // com.amazonaws.util.json.AwsJsonWriter
        public AwsJsonWriter d(String str) {
            this.f19108a.value(str);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AwsJsonToken d(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (AnonymousClass1.f19106a[jsonToken.ordinal()]) {
            case 1:
                return AwsJsonToken.BEGIN_ARRAY;
            case 2:
                return AwsJsonToken.END_ARRAY;
            case 3:
                return AwsJsonToken.BEGIN_OBJECT;
            case 4:
                return AwsJsonToken.END_OBJECT;
            case 5:
                return AwsJsonToken.FIELD_NAME;
            case 6:
                return AwsJsonToken.VALUE_BOOLEAN;
            case 7:
                return AwsJsonToken.VALUE_NUMBER;
            case 8:
                return AwsJsonToken.VALUE_NULL;
            case 9:
                return AwsJsonToken.VALUE_STRING;
            case 10:
                return null;
            default:
                return AwsJsonToken.UNKNOWN;
        }
    }

    @Override // com.amazonaws.util.json.AwsJsonFactory
    public AwsJsonWriter a(Writer writer) {
        return new GsonWriter(writer);
    }

    @Override // com.amazonaws.util.json.AwsJsonFactory
    public AwsJsonReader b(Reader reader) {
        return new GsonReader(reader);
    }
}
