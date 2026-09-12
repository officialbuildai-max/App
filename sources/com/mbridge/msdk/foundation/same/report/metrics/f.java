package com.mbridge.msdk.foundation.same.report.metrics;

import android.text.TextUtils;
import com.aliyun.player.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.tracker.m;
import com.mbridge.msdk.tracker.network.toolbox.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class f {
    private com.mbridge.msdk.tracker.e a(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(str);
        try {
            JSONObject jSONObject = new JSONObject(map);
            Boolean a11 = com.mbridge.msdk.foundation.same.b.b().a();
            if (a11 != null) {
                jSONObject.put("r_v_r", a11.booleanValue() ? 1 : 0);
            }
            eVar.a(jSONObject);
            eVar.b(0);
            eVar.a(0);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:6:0x0007, B:8:0x0020, B:11:0x0026, B:13:0x0036, B:16:0x0057, B:18:0x005d, B:20:0x0068, B:22:0x006e, B:23:0x0062, B:24:0x0072, B:26:0x0078, B:27:0x0080, B:29:0x0086, B:31:0x0091, B:33:0x0097, B:34:0x008b, B:36:0x0041, B:38:0x0045, B:41:0x004c, B:43:0x0050), top: B:5:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:6:0x0007, B:8:0x0020, B:11:0x0026, B:13:0x0036, B:16:0x0057, B:18:0x005d, B:20:0x0068, B:22:0x006e, B:23:0x0062, B:24:0x0072, B:26:0x0078, B:27:0x0080, B:29:0x0086, B:31:0x0091, B:33:0x0097, B:34:0x008b, B:36:0x0041, B:38:0x0045, B:41:0x004c, B:43:0x0050), top: B:5:0x0007, inners: #1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x004e -> B:44:0x0053). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0050 -> B:44:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> a(com.mbridge.msdk.foundation.same.report.metrics.c r4, java.lang.String r5) {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r4 == 0) goto La2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3d
            r1.<init>()     // Catch: java.lang.Exception -> L3d
            java.lang.String r2 = r4.o()     // Catch: java.lang.Exception -> L3d
            r1.append(r2)     // Catch: java.lang.Exception -> L3d
            r1.append(r5)     // Catch: java.lang.Exception -> L3d
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Exception -> L3d
            java.util.Map r1 = r4.r()     // Catch: java.lang.Exception -> L3d
            if (r1 == 0) goto L53
            boolean r2 = r1.containsKey(r5)     // Catch: java.lang.Exception -> L3d
            if (r2 == 0) goto L53
            java.lang.Object r5 = r1.get(r5)     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            java.lang.String r1 = "resource_type"
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            boolean r1 = r5 instanceof java.lang.String     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            if (r1 == 0) goto L41
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            goto L54
        L3d:
            r4 = move-exception
            goto L9b
        L3f:
            r5 = move-exception
            goto L4c
        L41:
            boolean r1 = r5 instanceof java.lang.Integer     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            if (r1 == 0) goto L53
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            int r5 = r5.intValue()     // Catch: java.lang.Exception -> L3d java.lang.NumberFormatException -> L3f
            goto L54
        L4c:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Exception -> L3d
            if (r1 == 0) goto L53
            r5.printStackTrace()     // Catch: java.lang.Exception -> L3d
        L53:
            r5 = -1
        L54:
            r1 = 1
            if (r5 != r1) goto L72
            java.util.List r5 = r4.j()     // Catch: java.lang.Exception -> L3d
            if (r5 == 0) goto L62
            java.util.List r4 = r4.j()     // Catch: java.lang.Exception -> L3d
            goto L66
        L62:
            java.util.List r4 = r4.g()     // Catch: java.lang.Exception -> L3d
        L66:
            if (r4 == 0) goto La2
            int r5 = r4.size()     // Catch: java.lang.Exception -> L3d
            if (r5 <= 0) goto La2
            r0.addAll(r4)     // Catch: java.lang.Exception -> L3d
            goto La2
        L72:
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r4.i()     // Catch: java.lang.Exception -> L3d
            if (r5 == 0) goto L80
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.i()     // Catch: java.lang.Exception -> L3d
            r0.add(r4)     // Catch: java.lang.Exception -> L3d
            goto La2
        L80:
            java.util.List r5 = r4.j()     // Catch: java.lang.Exception -> L3d
            if (r5 == 0) goto L8b
            java.util.List r4 = r4.j()     // Catch: java.lang.Exception -> L3d
            goto L8f
        L8b:
            java.util.List r4 = r4.g()     // Catch: java.lang.Exception -> L3d
        L8f:
            if (r4 == 0) goto La2
            int r5 = r4.size()     // Catch: java.lang.Exception -> L3d
            if (r5 <= 0) goto La2
            r0.addAll(r4)     // Catch: java.lang.Exception -> L3d
            goto La2
        L9b:
            boolean r5 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r5 == 0) goto La2
            r4.printStackTrace()
        La2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.metrics.f.a(com.mbridge.msdk.foundation.same.report.metrics.c, java.lang.String):java.util.List");
    }

    private Map<String, String> a(String str, String str2, m mVar) {
        e eVar = new e();
        try {
            g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 == null) {
                d11 = h.b().a();
            }
            if (!TextUtils.isEmpty(d11.k0())) {
                eVar.a("as_rid", d11.k0());
            }
            String J = d11.J();
            JSONArray I = d11.I();
            if (I != null) {
                int i11 = 0;
                while (true) {
                    if (i11 >= I.length()) {
                        break;
                    }
                    if (str.equals(I.getString(i11))) {
                        J = BuildConfig.VERSION_NAME;
                        break;
                    }
                    i11++;
                }
            }
            if (TextUtils.isEmpty(J)) {
                eVar.a("log_rate", -1);
            } else {
                eVar.a("log_rate", J);
            }
            if (!TextUtils.isEmpty(str2)) {
                l d12 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), str2);
                if (d12 != null && !TextUtils.isEmpty(d12.I())) {
                    eVar.a("us_rid", d12.I());
                }
                if (d12 != null && !TextUtils.isEmpty(d12.a())) {
                    eVar.a("u_stid", d12.a());
                }
                e b11 = d.b().b(str2);
                if (b11 != null) {
                    if (mVar != null && mVar.c() != null) {
                        try {
                            mVar.c().put("r_stid", b11.b("r_stid"));
                            b11.c("r_stid");
                        } catch (JSONException unused) {
                        }
                    }
                    eVar.a(b11);
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return eVar.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r23.i().getAdType() == 295) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0777 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:3:0x001b, B:5:0x0027, B:9:0x0032, B:11:0x003e, B:19:0x00a8, B:21:0x00ae, B:22:0x00ca, B:24:0x00d0, B:26:0x00d5, B:29:0x00f4, B:31:0x00fa, B:41:0x0128, B:43:0x012c, B:44:0x012f, B:45:0x0133, B:47:0x0139, B:50:0x0142, B:52:0x018a, B:53:0x01e7, B:55:0x01f1, B:57:0x0204, B:58:0x020d, B:59:0x0220, B:61:0x022f, B:62:0x023c, B:65:0x0244, B:67:0x024a, B:69:0x0250, B:70:0x026e, B:71:0x0279, B:73:0x0283, B:75:0x0289, B:76:0x02a7, B:77:0x02b2, B:79:0x02ba, B:81:0x02c0, B:82:0x02de, B:83:0x02e9, B:85:0x02f1, B:87:0x02f7, B:88:0x0315, B:89:0x0320, B:91:0x0328, B:93:0x032e, B:94:0x034c, B:95:0x0357, B:98:0x036c, B:100:0x0376, B:101:0x037c, B:102:0x0381, B:104:0x0387, B:106:0x0395, B:109:0x03a5, B:111:0x03ab, B:112:0x03f3, B:114:0x03fd, B:117:0x0409, B:119:0x040f, B:120:0x0428, B:121:0x042c, B:123:0x0432, B:124:0x044b, B:125:0x044e, B:127:0x0458, B:129:0x0467, B:130:0x0487, B:131:0x0490, B:134:0x0499, B:136:0x049f, B:137:0x04de, B:140:0x04ea, B:142:0x0500, B:143:0x0525, B:145:0x052b, B:146:0x0550, B:148:0x0554, B:150:0x0564, B:151:0x0569, B:153:0x0573, B:154:0x057c, B:156:0x0582, B:157:0x058f, B:159:0x05b0, B:161:0x05b7, B:162:0x05c4, B:164:0x05ce, B:165:0x05d7, B:167:0x05df, B:169:0x05e6, B:170:0x05f3, B:172:0x05fd, B:173:0x0606, B:174:0x0613, B:176:0x061b, B:180:0x062b, B:183:0x0639, B:185:0x065f, B:187:0x0665, B:188:0x066a, B:189:0x0668, B:190:0x0671, B:192:0x0679, B:194:0x067f, B:195:0x0684, B:196:0x0682, B:197:0x068b, B:200:0x0695, B:202:0x069d, B:203:0x06a5, B:205:0x06b3, B:207:0x06b9, B:208:0x06be, B:210:0x06cd, B:212:0x06d3, B:213:0x06d8, B:216:0x06e9, B:219:0x0709, B:221:0x0712, B:222:0x072f, B:224:0x073b, B:229:0x0749, B:231:0x0755, B:233:0x075f, B:236:0x0777, B:237:0x078a, B:239:0x0790, B:240:0x0795, B:241:0x0793, B:242:0x0781, B:243:0x0769, B:245:0x076f, B:247:0x07d0, B:248:0x079d, B:250:0x07ab, B:251:0x07be, B:253:0x07c4, B:254:0x07c9, B:255:0x07c7, B:256:0x07b5, B:260:0x071d, B:261:0x0705, B:263:0x06d6, B:264:0x06bc, B:270:0x0549, B:271:0x051e, B:273:0x04b8, B:274:0x04bc, B:276:0x04c2, B:277:0x04db, B:278:0x03c6, B:279:0x03cc, B:281:0x03d4, B:282:0x03ed, B:284:0x0217, B:285:0x01c9, B:292:0x00b6, B:294:0x00bc, B:296:0x00c7, B:297:0x00c1, B:299:0x0063, B:304:0x0077, B:306:0x0082, B:308:0x0088, B:310:0x0093, B:312:0x0099, B:314:0x008d, B:316:0x009f, B:326:0x005a, B:13:0x0043, B:15:0x0049, B:34:0x0106, B:36:0x0121), top: B:2:0x001b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0790 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:3:0x001b, B:5:0x0027, B:9:0x0032, B:11:0x003e, B:19:0x00a8, B:21:0x00ae, B:22:0x00ca, B:24:0x00d0, B:26:0x00d5, B:29:0x00f4, B:31:0x00fa, B:41:0x0128, B:43:0x012c, B:44:0x012f, B:45:0x0133, B:47:0x0139, B:50:0x0142, B:52:0x018a, B:53:0x01e7, B:55:0x01f1, B:57:0x0204, B:58:0x020d, B:59:0x0220, B:61:0x022f, B:62:0x023c, B:65:0x0244, B:67:0x024a, B:69:0x0250, B:70:0x026e, B:71:0x0279, B:73:0x0283, B:75:0x0289, B:76:0x02a7, B:77:0x02b2, B:79:0x02ba, B:81:0x02c0, B:82:0x02de, B:83:0x02e9, B:85:0x02f1, B:87:0x02f7, B:88:0x0315, B:89:0x0320, B:91:0x0328, B:93:0x032e, B:94:0x034c, B:95:0x0357, B:98:0x036c, B:100:0x0376, B:101:0x037c, B:102:0x0381, B:104:0x0387, B:106:0x0395, B:109:0x03a5, B:111:0x03ab, B:112:0x03f3, B:114:0x03fd, B:117:0x0409, B:119:0x040f, B:120:0x0428, B:121:0x042c, B:123:0x0432, B:124:0x044b, B:125:0x044e, B:127:0x0458, B:129:0x0467, B:130:0x0487, B:131:0x0490, B:134:0x0499, B:136:0x049f, B:137:0x04de, B:140:0x04ea, B:142:0x0500, B:143:0x0525, B:145:0x052b, B:146:0x0550, B:148:0x0554, B:150:0x0564, B:151:0x0569, B:153:0x0573, B:154:0x057c, B:156:0x0582, B:157:0x058f, B:159:0x05b0, B:161:0x05b7, B:162:0x05c4, B:164:0x05ce, B:165:0x05d7, B:167:0x05df, B:169:0x05e6, B:170:0x05f3, B:172:0x05fd, B:173:0x0606, B:174:0x0613, B:176:0x061b, B:180:0x062b, B:183:0x0639, B:185:0x065f, B:187:0x0665, B:188:0x066a, B:189:0x0668, B:190:0x0671, B:192:0x0679, B:194:0x067f, B:195:0x0684, B:196:0x0682, B:197:0x068b, B:200:0x0695, B:202:0x069d, B:203:0x06a5, B:205:0x06b3, B:207:0x06b9, B:208:0x06be, B:210:0x06cd, B:212:0x06d3, B:213:0x06d8, B:216:0x06e9, B:219:0x0709, B:221:0x0712, B:222:0x072f, B:224:0x073b, B:229:0x0749, B:231:0x0755, B:233:0x075f, B:236:0x0777, B:237:0x078a, B:239:0x0790, B:240:0x0795, B:241:0x0793, B:242:0x0781, B:243:0x0769, B:245:0x076f, B:247:0x07d0, B:248:0x079d, B:250:0x07ab, B:251:0x07be, B:253:0x07c4, B:254:0x07c9, B:255:0x07c7, B:256:0x07b5, B:260:0x071d, B:261:0x0705, B:263:0x06d6, B:264:0x06bc, B:270:0x0549, B:271:0x051e, B:273:0x04b8, B:274:0x04bc, B:276:0x04c2, B:277:0x04db, B:278:0x03c6, B:279:0x03cc, B:281:0x03d4, B:282:0x03ed, B:284:0x0217, B:285:0x01c9, B:292:0x00b6, B:294:0x00bc, B:296:0x00c7, B:297:0x00c1, B:299:0x0063, B:304:0x0077, B:306:0x0082, B:308:0x0088, B:310:0x0093, B:312:0x0099, B:314:0x008d, B:316:0x009f, B:326:0x005a, B:13:0x0043, B:15:0x0049, B:34:0x0106, B:36:0x0121), top: B:2:0x001b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0793 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:3:0x001b, B:5:0x0027, B:9:0x0032, B:11:0x003e, B:19:0x00a8, B:21:0x00ae, B:22:0x00ca, B:24:0x00d0, B:26:0x00d5, B:29:0x00f4, B:31:0x00fa, B:41:0x0128, B:43:0x012c, B:44:0x012f, B:45:0x0133, B:47:0x0139, B:50:0x0142, B:52:0x018a, B:53:0x01e7, B:55:0x01f1, B:57:0x0204, B:58:0x020d, B:59:0x0220, B:61:0x022f, B:62:0x023c, B:65:0x0244, B:67:0x024a, B:69:0x0250, B:70:0x026e, B:71:0x0279, B:73:0x0283, B:75:0x0289, B:76:0x02a7, B:77:0x02b2, B:79:0x02ba, B:81:0x02c0, B:82:0x02de, B:83:0x02e9, B:85:0x02f1, B:87:0x02f7, B:88:0x0315, B:89:0x0320, B:91:0x0328, B:93:0x032e, B:94:0x034c, B:95:0x0357, B:98:0x036c, B:100:0x0376, B:101:0x037c, B:102:0x0381, B:104:0x0387, B:106:0x0395, B:109:0x03a5, B:111:0x03ab, B:112:0x03f3, B:114:0x03fd, B:117:0x0409, B:119:0x040f, B:120:0x0428, B:121:0x042c, B:123:0x0432, B:124:0x044b, B:125:0x044e, B:127:0x0458, B:129:0x0467, B:130:0x0487, B:131:0x0490, B:134:0x0499, B:136:0x049f, B:137:0x04de, B:140:0x04ea, B:142:0x0500, B:143:0x0525, B:145:0x052b, B:146:0x0550, B:148:0x0554, B:150:0x0564, B:151:0x0569, B:153:0x0573, B:154:0x057c, B:156:0x0582, B:157:0x058f, B:159:0x05b0, B:161:0x05b7, B:162:0x05c4, B:164:0x05ce, B:165:0x05d7, B:167:0x05df, B:169:0x05e6, B:170:0x05f3, B:172:0x05fd, B:173:0x0606, B:174:0x0613, B:176:0x061b, B:180:0x062b, B:183:0x0639, B:185:0x065f, B:187:0x0665, B:188:0x066a, B:189:0x0668, B:190:0x0671, B:192:0x0679, B:194:0x067f, B:195:0x0684, B:196:0x0682, B:197:0x068b, B:200:0x0695, B:202:0x069d, B:203:0x06a5, B:205:0x06b3, B:207:0x06b9, B:208:0x06be, B:210:0x06cd, B:212:0x06d3, B:213:0x06d8, B:216:0x06e9, B:219:0x0709, B:221:0x0712, B:222:0x072f, B:224:0x073b, B:229:0x0749, B:231:0x0755, B:233:0x075f, B:236:0x0777, B:237:0x078a, B:239:0x0790, B:240:0x0795, B:241:0x0793, B:242:0x0781, B:243:0x0769, B:245:0x076f, B:247:0x07d0, B:248:0x079d, B:250:0x07ab, B:251:0x07be, B:253:0x07c4, B:254:0x07c9, B:255:0x07c7, B:256:0x07b5, B:260:0x071d, B:261:0x0705, B:263:0x06d6, B:264:0x06bc, B:270:0x0549, B:271:0x051e, B:273:0x04b8, B:274:0x04bc, B:276:0x04c2, B:277:0x04db, B:278:0x03c6, B:279:0x03cc, B:281:0x03d4, B:282:0x03ed, B:284:0x0217, B:285:0x01c9, B:292:0x00b6, B:294:0x00bc, B:296:0x00c7, B:297:0x00c1, B:299:0x0063, B:304:0x0077, B:306:0x0082, B:308:0x0088, B:310:0x0093, B:312:0x0099, B:314:0x008d, B:316:0x009f, B:326:0x005a, B:13:0x0043, B:15:0x0049, B:34:0x0106, B:36:0x0121), top: B:2:0x001b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0781 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:3:0x001b, B:5:0x0027, B:9:0x0032, B:11:0x003e, B:19:0x00a8, B:21:0x00ae, B:22:0x00ca, B:24:0x00d0, B:26:0x00d5, B:29:0x00f4, B:31:0x00fa, B:41:0x0128, B:43:0x012c, B:44:0x012f, B:45:0x0133, B:47:0x0139, B:50:0x0142, B:52:0x018a, B:53:0x01e7, B:55:0x01f1, B:57:0x0204, B:58:0x020d, B:59:0x0220, B:61:0x022f, B:62:0x023c, B:65:0x0244, B:67:0x024a, B:69:0x0250, B:70:0x026e, B:71:0x0279, B:73:0x0283, B:75:0x0289, B:76:0x02a7, B:77:0x02b2, B:79:0x02ba, B:81:0x02c0, B:82:0x02de, B:83:0x02e9, B:85:0x02f1, B:87:0x02f7, B:88:0x0315, B:89:0x0320, B:91:0x0328, B:93:0x032e, B:94:0x034c, B:95:0x0357, B:98:0x036c, B:100:0x0376, B:101:0x037c, B:102:0x0381, B:104:0x0387, B:106:0x0395, B:109:0x03a5, B:111:0x03ab, B:112:0x03f3, B:114:0x03fd, B:117:0x0409, B:119:0x040f, B:120:0x0428, B:121:0x042c, B:123:0x0432, B:124:0x044b, B:125:0x044e, B:127:0x0458, B:129:0x0467, B:130:0x0487, B:131:0x0490, B:134:0x0499, B:136:0x049f, B:137:0x04de, B:140:0x04ea, B:142:0x0500, B:143:0x0525, B:145:0x052b, B:146:0x0550, B:148:0x0554, B:150:0x0564, B:151:0x0569, B:153:0x0573, B:154:0x057c, B:156:0x0582, B:157:0x058f, B:159:0x05b0, B:161:0x05b7, B:162:0x05c4, B:164:0x05ce, B:165:0x05d7, B:167:0x05df, B:169:0x05e6, B:170:0x05f3, B:172:0x05fd, B:173:0x0606, B:174:0x0613, B:176:0x061b, B:180:0x062b, B:183:0x0639, B:185:0x065f, B:187:0x0665, B:188:0x066a, B:189:0x0668, B:190:0x0671, B:192:0x0679, B:194:0x067f, B:195:0x0684, B:196:0x0682, B:197:0x068b, B:200:0x0695, B:202:0x069d, B:203:0x06a5, B:205:0x06b3, B:207:0x06b9, B:208:0x06be, B:210:0x06cd, B:212:0x06d3, B:213:0x06d8, B:216:0x06e9, B:219:0x0709, B:221:0x0712, B:222:0x072f, B:224:0x073b, B:229:0x0749, B:231:0x0755, B:233:0x075f, B:236:0x0777, B:237:0x078a, B:239:0x0790, B:240:0x0795, B:241:0x0793, B:242:0x0781, B:243:0x0769, B:245:0x076f, B:247:0x07d0, B:248:0x079d, B:250:0x07ab, B:251:0x07be, B:253:0x07c4, B:254:0x07c9, B:255:0x07c7, B:256:0x07b5, B:260:0x071d, B:261:0x0705, B:263:0x06d6, B:264:0x06bc, B:270:0x0549, B:271:0x051e, B:273:0x04b8, B:274:0x04bc, B:276:0x04c2, B:277:0x04db, B:278:0x03c6, B:279:0x03cc, B:281:0x03d4, B:282:0x03ed, B:284:0x0217, B:285:0x01c9, B:292:0x00b6, B:294:0x00bc, B:296:0x00c7, B:297:0x00c1, B:299:0x0063, B:304:0x0077, B:306:0x0082, B:308:0x0088, B:310:0x0093, B:312:0x0099, B:314:0x008d, B:316:0x009f, B:326:0x005a, B:13:0x0043, B:15:0x0049, B:34:0x0106, B:36:0x0121), top: B:2:0x001b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d0 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:3:0x001b, B:5:0x0027, B:9:0x0032, B:11:0x003e, B:19:0x00a8, B:21:0x00ae, B:22:0x00ca, B:24:0x00d0, B:26:0x00d5, B:29:0x00f4, B:31:0x00fa, B:41:0x0128, B:43:0x012c, B:44:0x012f, B:45:0x0133, B:47:0x0139, B:50:0x0142, B:52:0x018a, B:53:0x01e7, B:55:0x01f1, B:57:0x0204, B:58:0x020d, B:59:0x0220, B:61:0x022f, B:62:0x023c, B:65:0x0244, B:67:0x024a, B:69:0x0250, B:70:0x026e, B:71:0x0279, B:73:0x0283, B:75:0x0289, B:76:0x02a7, B:77:0x02b2, B:79:0x02ba, B:81:0x02c0, B:82:0x02de, B:83:0x02e9, B:85:0x02f1, B:87:0x02f7, B:88:0x0315, B:89:0x0320, B:91:0x0328, B:93:0x032e, B:94:0x034c, B:95:0x0357, B:98:0x036c, B:100:0x0376, B:101:0x037c, B:102:0x0381, B:104:0x0387, B:106:0x0395, B:109:0x03a5, B:111:0x03ab, B:112:0x03f3, B:114:0x03fd, B:117:0x0409, B:119:0x040f, B:120:0x0428, B:121:0x042c, B:123:0x0432, B:124:0x044b, B:125:0x044e, B:127:0x0458, B:129:0x0467, B:130:0x0487, B:131:0x0490, B:134:0x0499, B:136:0x049f, B:137:0x04de, B:140:0x04ea, B:142:0x0500, B:143:0x0525, B:145:0x052b, B:146:0x0550, B:148:0x0554, B:150:0x0564, B:151:0x0569, B:153:0x0573, B:154:0x057c, B:156:0x0582, B:157:0x058f, B:159:0x05b0, B:161:0x05b7, B:162:0x05c4, B:164:0x05ce, B:165:0x05d7, B:167:0x05df, B:169:0x05e6, B:170:0x05f3, B:172:0x05fd, B:173:0x0606, B:174:0x0613, B:176:0x061b, B:180:0x062b, B:183:0x0639, B:185:0x065f, B:187:0x0665, B:188:0x066a, B:189:0x0668, B:190:0x0671, B:192:0x0679, B:194:0x067f, B:195:0x0684, B:196:0x0682, B:197:0x068b, B:200:0x0695, B:202:0x069d, B:203:0x06a5, B:205:0x06b3, B:207:0x06b9, B:208:0x06be, B:210:0x06cd, B:212:0x06d3, B:213:0x06d8, B:216:0x06e9, B:219:0x0709, B:221:0x0712, B:222:0x072f, B:224:0x073b, B:229:0x0749, B:231:0x0755, B:233:0x075f, B:236:0x0777, B:237:0x078a, B:239:0x0790, B:240:0x0795, B:241:0x0793, B:242:0x0781, B:243:0x0769, B:245:0x076f, B:247:0x07d0, B:248:0x079d, B:250:0x07ab, B:251:0x07be, B:253:0x07c4, B:254:0x07c9, B:255:0x07c7, B:256:0x07b5, B:260:0x071d, B:261:0x0705, B:263:0x06d6, B:264:0x06bc, B:270:0x0549, B:271:0x051e, B:273:0x04b8, B:274:0x04bc, B:276:0x04c2, B:277:0x04db, B:278:0x03c6, B:279:0x03cc, B:281:0x03d4, B:282:0x03ed, B:284:0x0217, B:285:0x01c9, B:292:0x00b6, B:294:0x00bc, B:296:0x00c7, B:297:0x00c1, B:299:0x0063, B:304:0x0077, B:306:0x0082, B:308:0x0088, B:310:0x0093, B:312:0x0099, B:314:0x008d, B:316:0x009f, B:326:0x005a, B:13:0x0043, B:15:0x0049, B:34:0x0106, B:36:0x0121), top: B:2:0x001b, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5 A[Catch: Exception -> 0x002c, TRY_LEAVE, TryCatch #0 {Exception -> 0x002c, blocks: (B:3:0x001b, B:5:0x0027, B:9:0x0032, B:11:0x003e, B:19:0x00a8, B:21:0x00ae, B:22:0x00ca, B:24:0x00d0, B:26:0x00d5, B:29:0x00f4, B:31:0x00fa, B:41:0x0128, B:43:0x012c, B:44:0x012f, B:45:0x0133, B:47:0x0139, B:50:0x0142, B:52:0x018a, B:53:0x01e7, B:55:0x01f1, B:57:0x0204, B:58:0x020d, B:59:0x0220, B:61:0x022f, B:62:0x023c, B:65:0x0244, B:67:0x024a, B:69:0x0250, B:70:0x026e, B:71:0x0279, B:73:0x0283, B:75:0x0289, B:76:0x02a7, B:77:0x02b2, B:79:0x02ba, B:81:0x02c0, B:82:0x02de, B:83:0x02e9, B:85:0x02f1, B:87:0x02f7, B:88:0x0315, B:89:0x0320, B:91:0x0328, B:93:0x032e, B:94:0x034c, B:95:0x0357, B:98:0x036c, B:100:0x0376, B:101:0x037c, B:102:0x0381, B:104:0x0387, B:106:0x0395, B:109:0x03a5, B:111:0x03ab, B:112:0x03f3, B:114:0x03fd, B:117:0x0409, B:119:0x040f, B:120:0x0428, B:121:0x042c, B:123:0x0432, B:124:0x044b, B:125:0x044e, B:127:0x0458, B:129:0x0467, B:130:0x0487, B:131:0x0490, B:134:0x0499, B:136:0x049f, B:137:0x04de, B:140:0x04ea, B:142:0x0500, B:143:0x0525, B:145:0x052b, B:146:0x0550, B:148:0x0554, B:150:0x0564, B:151:0x0569, B:153:0x0573, B:154:0x057c, B:156:0x0582, B:157:0x058f, B:159:0x05b0, B:161:0x05b7, B:162:0x05c4, B:164:0x05ce, B:165:0x05d7, B:167:0x05df, B:169:0x05e6, B:170:0x05f3, B:172:0x05fd, B:173:0x0606, B:174:0x0613, B:176:0x061b, B:180:0x062b, B:183:0x0639, B:185:0x065f, B:187:0x0665, B:188:0x066a, B:189:0x0668, B:190:0x0671, B:192:0x0679, B:194:0x067f, B:195:0x0684, B:196:0x0682, B:197:0x068b, B:200:0x0695, B:202:0x069d, B:203:0x06a5, B:205:0x06b3, B:207:0x06b9, B:208:0x06be, B:210:0x06cd, B:212:0x06d3, B:213:0x06d8, B:216:0x06e9, B:219:0x0709, B:221:0x0712, B:222:0x072f, B:224:0x073b, B:229:0x0749, B:231:0x0755, B:233:0x075f, B:236:0x0777, B:237:0x078a, B:239:0x0790, B:240:0x0795, B:241:0x0793, B:242:0x0781, B:243:0x0769, B:245:0x076f, B:247:0x07d0, B:248:0x079d, B:250:0x07ab, B:251:0x07be, B:253:0x07c4, B:254:0x07c9, B:255:0x07c7, B:256:0x07b5, B:260:0x071d, B:261:0x0705, B:263:0x06d6, B:264:0x06bc, B:270:0x0549, B:271:0x051e, B:273:0x04b8, B:274:0x04bc, B:276:0x04c2, B:277:0x04db, B:278:0x03c6, B:279:0x03cc, B:281:0x03d4, B:282:0x03ed, B:284:0x0217, B:285:0x01c9, B:292:0x00b6, B:294:0x00bc, B:296:0x00c7, B:297:0x00c1, B:299:0x0063, B:304:0x0077, B:306:0x0082, B:308:0x0088, B:310:0x0093, B:312:0x0099, B:314:0x008d, B:316:0x009f, B:326:0x005a, B:13:0x0043, B:15:0x0049, B:34:0x0106, B:36:0x0121), top: B:2:0x001b, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, java.lang.String> b(java.lang.String r22, com.mbridge.msdk.foundation.same.report.metrics.c r23) {
        /*
            Method dump skipped, instructions count: 2062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.metrics.f.b(java.lang.String, com.mbridge.msdk.foundation.same.report.metrics.c):java.util.Map");
    }

    private Map<String, String> c(String str, c cVar) {
        return (cVar == null || TextUtils.isEmpty(str)) ? new HashMap() : cVar.b(str);
    }

    private Map<String, String> d(String str, c cVar) {
        e eVar = new e();
        try {
            if (str.equals("2000125")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000123")));
            } else if (str.equals("2000126")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000125")));
            } else if (str.equals("2000127")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000123")));
            } else if (str.equals("2000154")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000126")));
            } else if (str.equals("2000047")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000123")));
            } else if (str.equals("2000048")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000123")));
            } else if (str.equals("2000155")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000154")));
            } else if (str.equals("2000146")) {
                eVar.a("duration", Long.valueOf(cVar.a("2000130")));
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return eVar.a();
    }

    public Map<String, String> a(String str, c cVar) {
        HashMap hashMap = new HashMap();
        try {
            if (Arrays.asList(b.f35639e).contains(str)) {
                hashMap.put("auto_load", cVar != null ? cVar.c() : "");
            }
            if (cVar != null) {
                Map<String, Map<String, String>> r11 = cVar.r();
                String str2 = cVar.o() + str;
                if (r11.containsKey(str2) && r11.get(str2) != null) {
                    hashMap.putAll(r11.get(str2));
                }
                try {
                    Map<String, Map<String, String>> q11 = cVar.q();
                    String str3 = cVar.o() + "_" + cVar.l() + "_" + str;
                    if (q11.containsKey(str3) && q11.get(str3) != null) {
                        hashMap.putAll(q11.get(str3));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                e12.printStackTrace();
            }
        }
        return hashMap;
    }

    public void a(String str, m mVar, c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        Map<String, String> d11;
        HashMap hashMap = new HashMap();
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            cVar.i(str);
            Map<String, String> b11 = b(str, cVar);
            if (b11 != null) {
                hashMap.putAll(b11);
            }
            Map<String, String> a11 = a(str, cVar.w(), mVar);
            if (a11 != null) {
                hashMap.putAll(a11);
            }
            if (Arrays.asList(b.f35638d).contains(str) && (d11 = d(str, cVar)) != null) {
                hashMap.putAll(d11);
            }
            Map<String, String> a12 = a(str, cVar);
            if (a12 != null) {
                hashMap.putAll(a12);
            }
            if (!hashMap.containsKey("lrid") || TextUtils.isEmpty(hashMap.get("lrid"))) {
                hashMap.put("lrid", cVar.o());
            }
            if (hashMap.containsKey("lrid")) {
                String str2 = hashMap.get("lrid");
                if (!TextUtils.isEmpty(str2) && str2.contains("label_second")) {
                    hashMap.put("lrid", str2.replace("label_second", ""));
                }
            }
            if (hashMap.containsKey("n_lrid")) {
                String str3 = hashMap.get("n_lrid");
                if (!TextUtils.isEmpty(str3) && str3.contains("label_second")) {
                    hashMap.put("n_lrid", str3.replace("n_lrid", ""));
                }
            }
            Map<String, String> c11 = c(str, cVar);
            if (c11 != null) {
                hashMap.putAll(c11);
            }
            String str4 = "1";
            if (cVar.c() == null || !cVar.c().equals("1") || !Arrays.asList(b.f35636b).contains(str) || cVar.a() == 296) {
                if (Arrays.asList(b.f35647m).contains(str)) {
                    hashMap.put("use_local_dns", i.b().e() ? "1" : "0");
                    if (!i.b().d()) {
                        str4 = "0";
                    }
                    hashMap.put("local_dns_available", str4);
                }
                com.mbridge.msdk.tracker.e a13 = a(str, hashMap);
                if (mVar != null && a13 != null) {
                    mVar.d(a13);
                }
                if (aVar != null) {
                    aVar.a();
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public void b(String str, m mVar, c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            cVar.i(str);
            Map<String, String> a11 = a(str, cVar.w(), mVar);
            if (a11 != null) {
                hashMap.putAll(a11);
            }
            Map<String, String> a12 = a(str, cVar);
            if (a12 != null) {
                hashMap.putAll(a12);
            }
            Map<String, String> c11 = c(str, cVar);
            if (c11 != null) {
                hashMap.putAll(c11);
            }
            com.mbridge.msdk.tracker.e a13 = a(str, hashMap);
            if (mVar != null && a13 != null) {
                mVar.d(a13);
            }
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
