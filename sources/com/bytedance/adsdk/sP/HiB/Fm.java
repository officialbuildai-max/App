package com.bytedance.adsdk.sP.HiB;

import android.util.JsonReader;
import be.g;
import com.bytedance.adsdk.sP.TKC.sP.TzV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Fm {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x008b. Please report as an issue. */
    public static com.bytedance.adsdk.sP.TKC.sP.TzV Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg) throws IOException {
        char c11;
        String str;
        char c12;
        ArrayList arrayList = new ArrayList();
        float f11 = 0.0f;
        String str2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar = null;
        com.bytedance.adsdk.sP.TKC.Sj.Sj sj2 = null;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2 = null;
        TzV.Sj sj3 = null;
        TzV.sP sPVar3 = null;
        boolean z10 = false;
        com.bytedance.adsdk.sP.TKC.Sj.EjP ejP = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 100:
                    if (nextName.equals("d")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    if (nextName.equals("w")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c11 = '\b';
                        break;
                    }
                    break;
            }
            c11 = 65535;
            switch (c11) {
                case 0:
                    sj2 = EjP.Jcg(jsonReader, jcg);
                    break;
                case 1:
                    str = str2;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar4 = null;
                        String str3 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("n")) {
                                str3 = jsonReader.nextString();
                            } else if (nextName2.equals("v")) {
                                sPVar4 = EjP.Sj(jsonReader, jcg);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        str3.hashCode();
                        switch (str3.hashCode()) {
                            case 100:
                                if (str3.equals("d")) {
                                    c12 = 0;
                                    break;
                                }
                                break;
                            case 103:
                                if (str3.equals(g.f16474b)) {
                                    c12 = 1;
                                    break;
                                }
                                break;
                            case 111:
                                if (str3.equals("o")) {
                                    c12 = 2;
                                    break;
                                }
                                break;
                        }
                        c12 = 65535;
                        switch (c12) {
                            case 0:
                            case 1:
                                jcg.Sj(true);
                                arrayList.add(sPVar4);
                                break;
                            case 2:
                                sPVar = sPVar4;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        str2 = str;
                        break;
                    }
                    str2 = str;
                    break;
                case 2:
                    ejP = EjP.sP(jsonReader, jcg);
                    break;
                case 3:
                    sPVar2 = EjP.Sj(jsonReader, jcg);
                    break;
                case 4:
                    z10 = jsonReader.nextBoolean();
                    break;
                case 5:
                    str = str2;
                    sj3 = TzV.Sj.values()[jsonReader.nextInt() - 1];
                    str2 = str;
                    break;
                case 6:
                    str = str2;
                    sPVar3 = TzV.sP.values()[jsonReader.nextInt() - 1];
                    str2 = str;
                    break;
                case 7:
                    str = str2;
                    f11 = (float) jsonReader.nextDouble();
                    str2 = str;
                    break;
                case '\b':
                    str2 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    str = str2;
                    str2 = str;
                    break;
            }
        }
        return new com.bytedance.adsdk.sP.TKC.sP.TzV(str2, sPVar, arrayList, sj2, ejP == null ? new com.bytedance.adsdk.sP.TKC.Sj.EjP(Collections.singletonList(new com.bytedance.adsdk.sP.Jcg.Sj(100))) : ejP, sPVar2, sj3, sPVar3, f11, z10);
    }
}
