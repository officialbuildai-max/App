package com.bytedance.adsdk.sP.HiB;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.adsdk.sP.Jcg;
import com.bytedance.adsdk.sP.TEQ;
import com.bytedance.adsdk.sP.TKC.TKC.HiB;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ib {
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.bytedance.adsdk.sP.TEQ.Sj> EjP(android.util.JsonReader r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lce
            r0.<init>()     // Catch: java.lang.Exception -> Lce
        L5:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Exception -> Lce
            if (r1 == 0) goto Lcd
            com.bytedance.adsdk.sP.TEQ$Sj r1 = new com.bytedance.adsdk.sP.TEQ$Sj     // Catch: java.lang.Exception -> Lce
            r1.<init>()     // Catch: java.lang.Exception -> Lce
            r5.beginObject()     // Catch: java.lang.Exception -> Lce
        L13:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Exception -> Lce
            if (r2 == 0) goto Lc5
            java.lang.String r2 = r5.nextName()     // Catch: java.lang.Exception -> Lce
            int r3 = r2.hashCode()     // Catch: java.lang.Exception -> Lce
            r4 = 99
            if (r3 == r4) goto L7b
            r4 = 102(0x66, float:1.43E-43)
            if (r3 == r4) goto L71
            r4 = 108(0x6c, float:1.51E-43)
            if (r3 == r4) goto L67
            r4 = 115(0x73, float:1.61E-43)
            if (r3 == r4) goto L5d
            r4 = 3153(0xc51, float:4.418E-42)
            if (r3 == r4) goto L53
            r4 = 3449(0xd79, float:4.833E-42)
            if (r3 == r4) goto L49
            r4 = 96670(0x1799e, float:1.35464E-40)
            if (r3 == r4) goto L3f
            goto L85
        L3f:
            java.lang.String r3 = "ali"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lce
            if (r2 == 0) goto L85
            r2 = 6
            goto L86
        L49:
            java.lang.String r3 = "le"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lce
            if (r2 == 0) goto L85
            r2 = 1
            goto L86
        L53:
            java.lang.String r3 = "bs"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lce
            if (r2 == 0) goto L85
            r2 = 5
            goto L86
        L5d:
            java.lang.String r3 = "s"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lce
            if (r2 == 0) goto L85
            r2 = 2
            goto L86
        L67:
            java.lang.String r3 = "l"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lce
            if (r2 == 0) goto L85
            r2 = 0
            goto L86
        L71:
            java.lang.String r3 = "f"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lce
            if (r2 == 0) goto L85
            r2 = 4
            goto L86
        L7b:
            java.lang.String r3 = "c"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> Lce
            if (r2 == 0) goto L85
            r2 = 3
            goto L86
        L85:
            r2 = -1
        L86:
            switch(r2) {
                case 0: goto Lbd;
                case 1: goto Lb5;
                case 2: goto Lad;
                case 3: goto La5;
                case 4: goto L9d;
                case 5: goto L95;
                case 6: goto L8d;
                default: goto L89;
            }     // Catch: java.lang.Exception -> Lce
        L89:
            r5.skipValue()     // Catch: java.lang.Exception -> Lce
            goto L13
        L8d:
            java.lang.String r2 = r5.nextString()     // Catch: java.lang.Exception -> Lce
            r1.Jcg = r2     // Catch: java.lang.Exception -> Lce
            goto L13
        L95:
            int r2 = r5.nextInt()     // Catch: java.lang.Exception -> Lce
            r1.vS = r2     // Catch: java.lang.Exception -> Lce
            goto L13
        L9d:
            java.lang.String r2 = r5.nextString()     // Catch: java.lang.Exception -> Lce
            r1.EjP = r2     // Catch: java.lang.Exception -> Lce
            goto L13
        La5:
            java.lang.String r2 = r5.nextString()     // Catch: java.lang.Exception -> Lce
            r1.TKC = r2     // Catch: java.lang.Exception -> Lce
            goto L13
        Lad:
            int r2 = r5.nextInt()     // Catch: java.lang.Exception -> Lce
            r1.HiB = r2     // Catch: java.lang.Exception -> Lce
            goto L13
        Lb5:
            int r2 = r5.nextInt()     // Catch: java.lang.Exception -> Lce
            r1.sP = r2     // Catch: java.lang.Exception -> Lce
            goto L13
        Lbd:
            int r2 = r5.nextInt()     // Catch: java.lang.Exception -> Lce
            r1.Sj = r2     // Catch: java.lang.Exception -> Lce
            goto L13
        Lc5:
            r5.endObject()     // Catch: java.lang.Exception -> Lce
            r0.add(r1)     // Catch: java.lang.Exception -> Lce
            goto L5
        Lcd:
            return r0
        Lce:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.ib.EjP(android.util.JsonReader):java.util.List");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0062. Please report as an issue. */
    public static com.bytedance.adsdk.sP.Jcg Sj(JsonReader jsonReader) throws IOException {
        float Sj = com.bytedance.adsdk.sP.vS.vS.Sj();
        LongSparseArray<com.bytedance.adsdk.sP.TKC.TKC.HiB> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.sP.TKC.EjP> sparseArray = new SparseArray<>();
        Jcg.TKC tkc = new Jcg.TKC();
        Jcg.Sj sj2 = new Jcg.Sj();
        Jcg.sP sPVar = new Jcg.sP();
        com.bytedance.adsdk.sP.Jcg jcg = new com.bytedance.adsdk.sP.Jcg();
        jsonReader.beginObject();
        int i11 = 0;
        int i12 = 0;
        String str = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1408207997:
                    if (nextName.equals("assets")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1109732030:
                    if (nextName.equals("layers")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -865448777:
                    if (nextName.equals("globalEvent")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                    if (nextName.equals("v")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    if (nextName.equals("w")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3208:
                    if (nextName.equals("dl")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 3276:
                    if (nextName.equals("fr")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 3292:
                    if (nextName.equals("gc")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case 94623709:
                    if (nextName.equals("chars")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 97615364:
                    if (nextName.equals("fonts")) {
                        c11 = '\f';
                        break;
                    }
                    break;
                case 110364485:
                    if (nextName.equals("timer")) {
                        c11 = '\r';
                        break;
                    }
                    break;
                case 839250809:
                    if (nextName.equals("markers")) {
                        c11 = 14;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    Sj(jsonReader, jcg, hashMap, hashMap2);
                    continue;
                case 1:
                    Sj(jsonReader, jcg, arrayList, longSparseArray);
                    continue;
                case 2:
                    Sj(jsonReader, sPVar);
                    continue;
                case 3:
                    i12 = jsonReader.nextInt();
                    continue;
                case 4:
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.sP.vS.vS.Sj(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        jcg.Sj("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    } else {
                        continue;
                    }
                case 5:
                    i11 = jsonReader.nextInt();
                    continue;
                case 6:
                    str = jsonReader.nextString();
                    continue;
                case 7:
                    f13 = (float) jsonReader.nextDouble();
                    continue;
                case '\b':
                    Sj(jsonReader, sj2);
                    break;
                case '\t':
                    f12 = (float) jsonReader.nextDouble();
                    continue;
                case '\n':
                    f11 = ((float) jsonReader.nextDouble()) - 0.01f;
                    continue;
                case 11:
                    Sj(jsonReader, jcg, sparseArray);
                    break;
                case '\f':
                    Sj(jsonReader, hashMap3);
                    break;
                case '\r':
                    Sj(jsonReader, tkc);
                    break;
                case 14:
                    Sj(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        jcg.Sj(new Rect(0, 0, (int) (i11 * Sj), (int) (i12 * Sj)), f12, f11, f13, arrayList, longSparseArray, hashMap, hashMap2, sparseArray, hashMap3, arrayList2, tkc, str, sj2, sPVar);
        return jcg;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void Sj(android.util.JsonReader r7, com.bytedance.adsdk.sP.Jcg.Sj r8) {
        /*
            r7.beginObject()     // Catch: java.lang.Exception -> L91
        L3:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L8e
            java.lang.String r0 = r7.nextName()     // Catch: java.lang.Exception -> L91
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L91
            r2 = 3139(0xc43, float:4.399E-42)
            r3 = 1
            r4 = 2
            r5 = 3
            r6 = 4
            if (r1 == r2) goto L53
            r2 = 3232(0xca0, float:4.529E-42)
            if (r1 == r2) goto L49
            r2 = 3571(0xdf3, float:5.004E-42)
            if (r1 == r2) goto L3f
            r2 = 3666(0xe52, float:5.137E-42)
            if (r1 == r2) goto L35
            r2 = 98713(0x18199, float:1.38326E-40)
            if (r1 == r2) goto L2b
            goto L5d
        L2b:
            java.lang.String r1 = "cpf"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = r6
            goto L5e
        L35:
            java.lang.String r1 = "se"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = 0
            goto L5e
        L3f:
            java.lang.String r1 = "pc"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = r5
            goto L5e
        L49:
            java.lang.String r1 = "ee"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = r4
            goto L5e
        L53:
            java.lang.String r1 = "be"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L91
            if (r0 == 0) goto L5d
            r0 = r3
            goto L5e
        L5d:
            r0 = -1
        L5e:
            if (r0 == 0) goto L86
            if (r0 == r3) goto L7e
            if (r0 == r4) goto L77
            if (r0 == r5) goto L70
            if (r0 == r6) goto L6c
            r7.skipValue()     // Catch: java.lang.Exception -> L91
            goto L3
        L6c:
            sP(r7, r8)     // Catch: java.lang.Exception -> L91
            goto L3
        L70:
            int r0 = r7.nextInt()     // Catch: java.lang.Exception -> L91
            r8.EjP = r0     // Catch: java.lang.Exception -> L91
            goto L3
        L77:
            java.util.Map r0 = sP(r7)     // Catch: java.lang.Exception -> L91
            r8.TKC = r0     // Catch: java.lang.Exception -> L91
            goto L3
        L7e:
            java.util.Map r0 = sP(r7)     // Catch: java.lang.Exception -> L91
            r8.sP = r0     // Catch: java.lang.Exception -> L91
            goto L3
        L86:
            int r0 = r7.nextInt()     // Catch: java.lang.Exception -> L91
            r8.Sj = r0     // Catch: java.lang.Exception -> L91
            goto L3
        L8e:
            r7.endObject()     // Catch: java.lang.Exception -> L91
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.ib.Sj(android.util.JsonReader, com.bytedance.adsdk.sP.Jcg$Sj):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void Sj(android.util.JsonReader r6, com.bytedance.adsdk.sP.Jcg.TKC r7) {
        /*
            r6.beginObject()     // Catch: java.lang.Exception -> Ld5
        L3:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto Ld2
            java.lang.String r0 = r6.nextName()     // Catch: java.lang.Exception -> Ld5
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> Ld5
            r2 = 3123(0xc33, float:4.376E-42)
            r3 = 0
            r4 = 2
            r5 = -1
            if (r1 == r2) goto L6f
            r2 = 3239(0xca7, float:4.539E-42)
            if (r1 == r2) goto L65
            r2 = 3355(0xd1b, float:4.701E-42)
            if (r1 == r2) goto L5b
            r2 = 3418(0xd5a, float:4.79E-42)
            if (r1 == r2) goto L51
            r2 = 3704(0xe78, float:5.19E-42)
            if (r1 == r2) goto L47
            r2 = 107027(0x1a213, float:1.49977E-40)
            if (r1 == r2) goto L3d
            r2 = 3237004(0x31648c, float:4.536009E-39)
            if (r1 == r2) goto L33
            goto L79
        L33:
            java.lang.String r1 = "inel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto L79
            r0 = 4
            goto L7a
        L3d:
            java.lang.String r1 = "lel"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto L79
            r0 = 6
            goto L7a
        L47:
            java.lang.String r1 = "tl"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto L79
            r0 = r4
            goto L7a
        L51:
            java.lang.String r1 = "ke"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto L79
            r0 = r3
            goto L7a
        L5b:
            java.lang.String r1 = "id"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto L79
            r0 = 1
            goto L7a
        L65:
            java.lang.String r1 = "el"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto L79
            r0 = 5
            goto L7a
        L6f:
            java.lang.String r1 = "at"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto L79
            r0 = 3
            goto L7a
        L79:
            r0 = r5
        L7a:
            switch(r0) {
                case 0: goto Lca;
                case 1: goto Lc2;
                case 2: goto Lba;
                case 3: goto Lb2;
                case 4: goto L91;
                case 5: goto L89;
                case 6: goto L81;
                default: goto L7d;
            }     // Catch: java.lang.Exception -> Ld5
        L7d:
            r6.skipValue()     // Catch: java.lang.Exception -> Ld5
            goto L3
        L81:
            org.json.JSONArray r0 = TKC(r6)     // Catch: java.lang.Exception -> Ld5
            r7.Jcg = r0     // Catch: java.lang.Exception -> Ld5
            goto L3
        L89:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> Ld5
            r7.vS = r0     // Catch: java.lang.Exception -> Ld5
            goto L3
        L91:
            int[] r0 = new int[]{r5, r5}     // Catch: java.lang.Exception -> Ld5
            r7.HiB = r0     // Catch: java.lang.Exception -> Ld5
            r6.beginArray()     // Catch: java.lang.Exception -> Ld5
        L9a:
            if (r3 >= r4) goto Lad
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> Ld5
            if (r0 == 0) goto Laa
            int[] r0 = r7.HiB     // Catch: java.lang.Exception -> Ld5
            int r1 = r6.nextInt()     // Catch: java.lang.Exception -> Ld5
            r0[r3] = r1     // Catch: java.lang.Exception -> Ld5
        Laa:
            int r3 = r3 + 1
            goto L9a
        Lad:
            r6.endArray()     // Catch: java.lang.Exception -> Ld5
            goto L3
        Lb2:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> Ld5
            r7.EjP = r0     // Catch: java.lang.Exception -> Ld5
            goto L3
        Lba:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> Ld5
            r7.TKC = r0     // Catch: java.lang.Exception -> Ld5
            goto L3
        Lc2:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> Ld5
            r7.sP = r0     // Catch: java.lang.Exception -> Ld5
            goto L3
        Lca:
            int r0 = r6.nextInt()     // Catch: java.lang.Exception -> Ld5
            r7.Sj = r0     // Catch: java.lang.Exception -> Ld5
            goto L3
        Ld2:
            r6.endObject()     // Catch: java.lang.Exception -> Ld5
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.ib.Sj(android.util.JsonReader, com.bytedance.adsdk.sP.Jcg$TKC):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void Sj(android.util.JsonReader r7, com.bytedance.adsdk.sP.Jcg.sP r8) {
        /*
            r0 = 0
            r1 = 1
            r7.beginObject()     // Catch: java.lang.Exception -> L91
        L5:
            boolean r2 = r7.hasNext()     // Catch: java.lang.Exception -> L91
            if (r2 == 0) goto L8e
            java.lang.String r2 = r7.nextName()     // Catch: java.lang.Exception -> L91
            int r3 = r2.hashCode()     // Catch: java.lang.Exception -> L91
            r4 = 3239(0xca7, float:4.539E-42)
            r5 = 2
            r6 = -1
            if (r3 == r4) goto L38
            r4 = 107027(0x1a213, float:1.49977E-40)
            if (r3 == r4) goto L2e
            r4 = 3237004(0x31648c, float:4.536009E-39)
            if (r3 == r4) goto L24
            goto L42
        L24:
            java.lang.String r3 = "inel"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L91
            if (r2 == 0) goto L42
            r2 = r0
            goto L43
        L2e:
            java.lang.String r3 = "lel"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L91
            if (r2 == 0) goto L42
            r2 = r5
            goto L43
        L38:
            java.lang.String r3 = "el"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L91
            if (r2 == 0) goto L42
            r2 = r1
            goto L43
        L42:
            r2 = r6
        L43:
            if (r2 == 0) goto L5b
            if (r2 == r1) goto L54
            if (r2 == r5) goto L4d
            r7.skipValue()     // Catch: java.lang.Exception -> L91
            goto L5
        L4d:
            org.json.JSONArray r2 = TKC(r7)     // Catch: java.lang.Exception -> L91
            r8.TKC = r2     // Catch: java.lang.Exception -> L91
            goto L5
        L54:
            java.lang.String r2 = r7.nextString()     // Catch: java.lang.Exception -> L91
            r8.Sj = r2     // Catch: java.lang.Exception -> L91
            goto L5
        L5b:
            int[] r2 = new int[]{r6, r6}     // Catch: java.lang.Exception -> L91
            int[][] r3 = new int[r1]     // Catch: java.lang.Exception -> L91
            r3[r0] = r2     // Catch: java.lang.Exception -> L91
            r8.sP = r3     // Catch: java.lang.Exception -> L91
            r7.beginArray()     // Catch: java.lang.Exception -> L91
            boolean r2 = r7.hasNext()     // Catch: java.lang.Exception -> L91
            if (r2 == 0) goto L89
            r7.beginArray()     // Catch: java.lang.Exception -> L91
            r2 = r0
        L72:
            if (r2 >= r5) goto L86
            boolean r3 = r7.hasNext()     // Catch: java.lang.Exception -> L91
            if (r3 == 0) goto L84
            int[][] r3 = r8.sP     // Catch: java.lang.Exception -> L91
            r3 = r3[r0]     // Catch: java.lang.Exception -> L91
            int r4 = r7.nextInt()     // Catch: java.lang.Exception -> L91
            r3[r2] = r4     // Catch: java.lang.Exception -> L91
        L84:
            int r2 = r2 + r1
            goto L72
        L86:
            r7.endArray()     // Catch: java.lang.Exception -> L91
        L89:
            r7.endArray()     // Catch: java.lang.Exception -> L91
            goto L5
        L8e:
            r7.endObject()     // Catch: java.lang.Exception -> L91
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.ib.Sj(android.util.JsonReader, com.bytedance.adsdk.sP.Jcg$sP):void");
    }

    private static void Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg, SparseArray<com.bytedance.adsdk.sP.TKC.EjP> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.sP.TKC.EjP Sj = Fmk.Sj(jsonReader, jcg);
            sparseArray.put(Sj.hashCode(), Sj);
        }
        jsonReader.endArray();
    }

    private static void Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg, List<com.bytedance.adsdk.sP.TKC.TKC.HiB> list, LongSparseArray<com.bytedance.adsdk.sP.TKC.TKC.HiB> longSparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.sP.TKC.TKC.HiB Sj = zR.Sj(jsonReader, jcg);
            Sj.Ym();
            HiB.Sj sj2 = HiB.Sj.PRE_COMP;
            list.add(Sj);
            longSparseArray.put(Sj.HiB(), Sj);
        }
        jsonReader.endArray();
    }

    private static void Sj(JsonReader jsonReader, com.bytedance.adsdk.sP.Jcg jcg, Map<String, List<com.bytedance.adsdk.sP.TKC.TKC.HiB>> map, Map<String, com.bytedance.adsdk.sP.TEQ> map2) throws IOException {
        int i11;
        int i12 = 2;
        int i13 = -1;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            int i14 = 0;
            int i15 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            List<TEQ.Sj> list = null;
            String str5 = null;
            int[][] iArr = null;
            JSONArray jSONArray = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.hashCode();
                switch (nextName.hashCode()) {
                    case -1109732030:
                        if (nextName.equals("layers")) {
                            i11 = 0;
                            break;
                        }
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            i11 = 1;
                            break;
                        }
                        break;
                    case 112:
                        if (nextName.equals(TtmlNode.TAG_P)) {
                            i11 = i12;
                            break;
                        }
                        break;
                    case ASSET_FAILED_STATUS_CODE_VALUE:
                        if (nextName.equals(TmcStartParams.KEY_URL_SHORT)) {
                            i11 = 3;
                            break;
                        }
                        break;
                    case JSON_ENCODE_ERROR_VALUE:
                        if (nextName.equals("w")) {
                            i11 = 4;
                            break;
                        }
                        break;
                    case 3239:
                        if (nextName.equals("el")) {
                            i11 = 5;
                            break;
                        }
                        break;
                    case 3355:
                        if (nextName.equals("id")) {
                            i11 = 6;
                            break;
                        }
                        break;
                    case 3695:
                        if (nextName.equals("tc")) {
                            i11 = 7;
                            break;
                        }
                        break;
                    case 107027:
                        if (nextName.equals("lel")) {
                            i11 = 8;
                            break;
                        }
                        break;
                    case 112793:
                        if (nextName.equals("rel")) {
                            i11 = 9;
                            break;
                        }
                        break;
                    case 3237004:
                        if (nextName.equals("inel")) {
                            i11 = 10;
                            break;
                        }
                        break;
                }
                i11 = i13;
                switch (i11) {
                    case 0:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.sP.TKC.TKC.HiB Sj = zR.Sj(jsonReader, jcg);
                            longSparseArray.put(Sj.HiB(), Sj);
                            arrayList.add(Sj);
                        }
                        jsonReader.endArray();
                        break;
                    case 1:
                        i15 = jsonReader.nextInt();
                        break;
                    case 2:
                        str2 = jsonReader.nextString();
                        break;
                    case 3:
                        str3 = jsonReader.nextString();
                        break;
                    case 4:
                        i14 = jsonReader.nextInt();
                        break;
                    case 5:
                        str5 = jsonReader.nextString();
                        break;
                    case 6:
                        str = jsonReader.nextString();
                        break;
                    case 7:
                        jsonReader.beginArray();
                        list = EjP(jsonReader);
                        jsonReader.endArray();
                        break;
                    case 8:
                        jSONArray = TKC(jsonReader);
                        break;
                    case 9:
                        str4 = jsonReader.nextString();
                        break;
                    case 10:
                        int[][] iArr2 = {new int[]{i13, i13}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i16 = 0; i16 < i12; i16++) {
                                if (jsonReader.hasNext()) {
                                    iArr2[0][i16] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        iArr = iArr2;
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
                i12 = 2;
                i13 = -1;
            }
            jsonReader.endObject();
            if (str2 != null) {
                com.bytedance.adsdk.sP.TEQ teq = new com.bytedance.adsdk.sP.TEQ(i14, i15, str, str2, str3, str4, list, str5, iArr, jSONArray);
                map2.put(teq.Dq(), teq);
            } else {
                map.put(str, arrayList);
            }
            i12 = 2;
            i13 = -1;
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        switch(r4) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L32;
            default: goto L36;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r0 = (float) r6.nextDouble();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        r1 = (float) r6.nextDouble();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        r2 = r6.nextString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:
    
        r6.skipValue();
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void Sj(android.util.JsonReader r6, java.util.List<com.bytedance.adsdk.sP.TKC.vS> r7) throws java.io.IOException {
        /*
            r6.beginArray()
        L3:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L6a
            r6.beginObject()
            r0 = 0
            r1 = 0
            r2 = r1
            r1 = r0
        L10:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L5e
            java.lang.String r3 = r6.nextName()
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3178: goto L3c;
                case 3214: goto L31;
                case 3705: goto L26;
                default: goto L25;
            }
        L25:
            goto L46
        L26:
            java.lang.String r5 = "tm"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L2f
            goto L46
        L2f:
            r4 = 2
            goto L46
        L31:
            java.lang.String r5 = "dr"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L3a
            goto L46
        L3a:
            r4 = 1
            goto L46
        L3c:
            java.lang.String r5 = "cm"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L45
            goto L46
        L45:
            r4 = 0
        L46:
            switch(r4) {
                case 0: goto L59;
                case 1: goto L53;
                case 2: goto L4d;
                default: goto L49;
            }
        L49:
            r6.skipValue()
            goto L10
        L4d:
            double r3 = r6.nextDouble()
            float r0 = (float) r3
            goto L10
        L53:
            double r3 = r6.nextDouble()
            float r1 = (float) r3
            goto L10
        L59:
            java.lang.String r2 = r6.nextString()
            goto L10
        L5e:
            r6.endObject()
            com.bytedance.adsdk.sP.TKC.vS r3 = new com.bytedance.adsdk.sP.TKC.vS
            r3.<init>(r2, r0, r1)
            r7.add(r3)
            goto L3
        L6a:
            r6.endArray()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.ib.Sj(android.util.JsonReader, java.util.List):void");
    }

    private static void Sj(JsonReader jsonReader, Map<String, com.bytedance.adsdk.sP.TKC.TKC> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.sP.TKC.TKC Sj = sef.Sj(jsonReader);
                    map.put(Sj.sP(), Sj);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static JSONArray TKC(JsonReader jsonReader) {
        char c11;
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    int hashCode = nextName.hashCode();
                    if (hashCode != 3324) {
                        if (hashCode == 116753 && nextName.equals("vid")) {
                            c11 = 0;
                        }
                        c11 = 65535;
                    } else {
                        if (nextName.equals("hd")) {
                            c11 = 1;
                        }
                        c11 = 65535;
                    }
                    if (c11 == 0) {
                        jSONObject.put("vid", jsonReader.nextString());
                    } else if (c11 != 1) {
                        jsonReader.skipValue();
                    } else {
                        try {
                            jSONObject.put("hd", jsonReader.nextInt());
                        } catch (JSONException unused) {
                        }
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    private static Map<String, Object> sP(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("lel")) {
                hashMap.put("lel", TKC(jsonReader));
            } else if (nextName.equals("lottie_back")) {
                JSONObject jSONObject = new JSONObject();
                hashMap.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    nextName2.hashCode();
                    if (nextName2.equals("hd")) {
                        try {
                            jSONObject.putOpt("hd", Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Object remove = hashMap.remove("lottie_back");
        if (remove instanceof JSONObject) {
            Object obj = hashMap.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(remove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(remove);
                hashMap.put("lel", jSONArray);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void sP(android.util.JsonReader r5, com.bytedance.adsdk.sP.Jcg.Sj r6) {
        /*
            r5.beginObject()     // Catch: java.io.IOException -> L62
        L3:
            boolean r0 = r5.hasNext()     // Catch: java.io.IOException -> L62
            if (r0 == 0) goto L5f
            java.lang.String r0 = r5.nextName()     // Catch: java.io.IOException -> L62
            int r1 = r0.hashCode()     // Catch: java.io.IOException -> L62
            r2 = 3239(0xca7, float:4.539E-42)
            r3 = 1
            r4 = 2
            if (r1 == r2) goto L35
            r2 = 3276(0xccc, float:4.59E-42)
            if (r1 == r2) goto L2b
            r2 = 107027(0x1a213, float:1.49977E-40)
            if (r1 == r2) goto L21
            goto L3f
        L21:
            java.lang.String r1 = "lel"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L62
            if (r0 == 0) goto L3f
            r0 = r4
            goto L40
        L2b:
            java.lang.String r1 = "fr"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L62
            if (r0 == 0) goto L3f
            r0 = 0
            goto L40
        L35:
            java.lang.String r1 = "el"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L62
            if (r0 == 0) goto L3f
            r0 = r3
            goto L40
        L3f:
            r0 = -1
        L40:
            if (r0 == 0) goto L58
            if (r0 == r3) goto L51
            if (r0 == r4) goto L4a
            r5.skipValue()     // Catch: java.io.IOException -> L62
            goto L3
        L4a:
            org.json.JSONArray r0 = TKC(r5)     // Catch: java.io.IOException -> L62
            r6.Jcg = r0     // Catch: java.io.IOException -> L62
            goto L3
        L51:
            java.lang.String r0 = r5.nextString()     // Catch: java.io.IOException -> L62
            r6.vS = r0     // Catch: java.io.IOException -> L62
            goto L3
        L58:
            int r0 = r5.nextInt()     // Catch: java.io.IOException -> L62
            r6.HiB = r0     // Catch: java.io.IOException -> L62
            goto L3
        L5f:
            r5.endObject()     // Catch: java.io.IOException -> L62
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.ib.sP(android.util.JsonReader, com.bytedance.adsdk.sP.Jcg$Sj):void");
    }
}
