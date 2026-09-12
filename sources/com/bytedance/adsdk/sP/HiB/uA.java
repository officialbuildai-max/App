package com.bytedance.adsdk.sP.HiB;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.sP.TKC.sP;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.same.report.j;
import java.io.IOException;

/* loaded from: classes2.dex */
public class uA implements Ei<com.bytedance.adsdk.sP.TKC.sP> {
    public static final uA Sj = new uA();

    private uA() {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0029. Please report as an issue. */
    @Override // com.bytedance.adsdk.sP.HiB.Ei
    /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.sP.TKC.sP sP(JsonReader jsonReader, float f11) throws IOException {
        sP.Sj sj2 = sP.Sj.CENTER;
        jsonReader.beginObject();
        sP.Sj sj3 = sj2;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        boolean z10 = true;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 102:
                    if (nextName.equals("f")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 106:
                    if (nextName.equals(j.f35620b)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case INVALID_INDEX_URL_VALUE:
                    if (nextName.equals("s")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case GZIP_ENCODE_ERROR_VALUE:
                    if (nextName.equals("t")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 3452:
                    if (nextName.equals("lh")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3463:
                    if (nextName.equals(TmcStartParams.KEY_LANDSCAPE_SHORT)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 3543:
                    if (nextName.equals("of")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 3587:
                    if (nextName.equals("ps")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case 3687:
                    if (nextName.equals("sz")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        c11 = '\f';
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    str2 = jsonReader.nextString();
                    break;
                case 1:
                    int nextInt = jsonReader.nextInt();
                    sj3 = sP.Sj.CENTER;
                    if (nextInt <= sj3.ordinal() && nextInt >= 0) {
                        sj3 = sP.Sj.values()[nextInt];
                        break;
                    }
                    break;
                case 2:
                    f12 = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    i12 = RiZ.Sj(jsonReader);
                    break;
                case 5:
                    f13 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    f14 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    z10 = jsonReader.nextBoolean();
                    break;
                case '\b':
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f11, ((float) jsonReader.nextDouble()) * f11);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case '\t':
                    i13 = RiZ.Sj(jsonReader);
                    break;
                case '\n':
                    f15 = (float) jsonReader.nextDouble();
                    break;
                case 11:
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f11, ((float) jsonReader.nextDouble()) * f11);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                case '\f':
                    i11 = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.sP.TKC.sP(str, str2, f12, sj3, i11, f13, f14, i12, i13, f15, z10, pointF, pointF2);
    }
}
