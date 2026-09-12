package com.bytedance.adsdk.sP.HiB;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class RiZ {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.adsdk.sP.HiB.RiZ$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Sj;

        static {
            int[] iArr = new int[JsonToken.values().length];
            Sj = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Sj[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Sj[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF EjP(JsonReader jsonReader, float f11) throws IOException {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f11, nextDouble2 * f11);
    }

    private static PointF HiB(JsonReader jsonReader, float f11) throws IOException {
        jsonReader.beginObject();
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("x")) {
                f12 = sP(jsonReader);
            } else if (nextName.equals("y")) {
                f13 = sP(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new PointF(f12 * f11, f13 * f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Sj(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> Sj(JsonReader jsonReader, float f11) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(sP(jsonReader, f11));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    private static PointF TKC(JsonReader jsonReader, float f11) throws IOException {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f11, nextDouble2 * f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float sP(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        int i11 = AnonymousClass1.Sj[peek.ordinal()];
        if (i11 == 1) {
            return (float) jsonReader.nextDouble();
        }
        if (i11 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type ".concat(String.valueOf(peek)));
        }
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return nextDouble;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF sP(JsonReader jsonReader, float f11) throws IOException {
        int i11 = AnonymousClass1.Sj[jsonReader.peek().ordinal()];
        if (i11 == 1) {
            return TKC(jsonReader, f11);
        }
        if (i11 == 2) {
            return EjP(jsonReader, f11);
        }
        if (i11 == 3) {
            return HiB(jsonReader, f11);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
    }
}
