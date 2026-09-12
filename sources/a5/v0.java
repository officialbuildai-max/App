package a5;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class v0 extends i1 implements z0 {

    /* renamed from: j, reason: collision with root package name */
    public static v0 f428j = new v0();

    /* renamed from: k, reason: collision with root package name */
    private static final int f429k = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j(o0Var, obj, obj2, type, i11, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dc, code lost:
    
        if (e(r24, r0, com.alibaba.fastjson.a.toJSONString(r1)) != false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0252 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:19:0x0052, B:24:0x0059, B:26:0x0065, B:32:0x0080, B:33:0x0091, B:34:0x00a1, B:36:0x00a7, B:38:0x00b9, B:41:0x00c1, B:44:0x00c6, B:46:0x00d0, B:48:0x00d4, B:54:0x00e3, B:57:0x00ed, B:59:0x00f1, B:62:0x00f9, B:65:0x00fe, B:67:0x0108, B:69:0x010c, B:72:0x0117, B:75:0x0121, B:77:0x0125, B:80:0x012d, B:83:0x0132, B:85:0x013c, B:87:0x0140, B:90:0x014b, B:93:0x0155, B:95:0x0159, B:98:0x0161, B:101:0x0166, B:103:0x0170, B:105:0x0174, B:108:0x0180, B:111:0x018b, B:113:0x018f, B:116:0x0197, B:119:0x019c, B:121:0x01a6, B:123:0x01aa, B:124:0x01b3, B:125:0x01b9, B:127:0x01bd, B:130:0x01c5, B:133:0x01ca, B:135:0x01d4, B:137:0x01d8, B:138:0x01e2, B:141:0x01eb, B:143:0x01f6, B:145:0x01fa, B:147:0x0205, B:150:0x023a, B:152:0x024c, B:154:0x0252, B:156:0x0257, B:157:0x025a, B:159:0x0262, B:160:0x0265, B:162:0x0294, B:164:0x029e, B:166:0x02a6, B:167:0x02b0, B:169:0x02b8, B:171:0x02bc, B:173:0x02c0, B:175:0x02cb, B:176:0x02d1, B:180:0x02df, B:183:0x026b, B:184:0x026e, B:186:0x0276, B:188:0x028a, B:189:0x028d, B:190:0x027e, B:192:0x0282, B:196:0x0225, B:208:0x0079), top: B:18:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0294 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:19:0x0052, B:24:0x0059, B:26:0x0065, B:32:0x0080, B:33:0x0091, B:34:0x00a1, B:36:0x00a7, B:38:0x00b9, B:41:0x00c1, B:44:0x00c6, B:46:0x00d0, B:48:0x00d4, B:54:0x00e3, B:57:0x00ed, B:59:0x00f1, B:62:0x00f9, B:65:0x00fe, B:67:0x0108, B:69:0x010c, B:72:0x0117, B:75:0x0121, B:77:0x0125, B:80:0x012d, B:83:0x0132, B:85:0x013c, B:87:0x0140, B:90:0x014b, B:93:0x0155, B:95:0x0159, B:98:0x0161, B:101:0x0166, B:103:0x0170, B:105:0x0174, B:108:0x0180, B:111:0x018b, B:113:0x018f, B:116:0x0197, B:119:0x019c, B:121:0x01a6, B:123:0x01aa, B:124:0x01b3, B:125:0x01b9, B:127:0x01bd, B:130:0x01c5, B:133:0x01ca, B:135:0x01d4, B:137:0x01d8, B:138:0x01e2, B:141:0x01eb, B:143:0x01f6, B:145:0x01fa, B:147:0x0205, B:150:0x023a, B:152:0x024c, B:154:0x0252, B:156:0x0257, B:157:0x025a, B:159:0x0262, B:160:0x0265, B:162:0x0294, B:164:0x029e, B:166:0x02a6, B:167:0x02b0, B:169:0x02b8, B:171:0x02bc, B:173:0x02c0, B:175:0x02cb, B:176:0x02d1, B:180:0x02df, B:183:0x026b, B:184:0x026e, B:186:0x0276, B:188:0x028a, B:189:0x028d, B:190:0x027e, B:192:0x0282, B:196:0x0225, B:208:0x0079), top: B:18:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x029e A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:19:0x0052, B:24:0x0059, B:26:0x0065, B:32:0x0080, B:33:0x0091, B:34:0x00a1, B:36:0x00a7, B:38:0x00b9, B:41:0x00c1, B:44:0x00c6, B:46:0x00d0, B:48:0x00d4, B:54:0x00e3, B:57:0x00ed, B:59:0x00f1, B:62:0x00f9, B:65:0x00fe, B:67:0x0108, B:69:0x010c, B:72:0x0117, B:75:0x0121, B:77:0x0125, B:80:0x012d, B:83:0x0132, B:85:0x013c, B:87:0x0140, B:90:0x014b, B:93:0x0155, B:95:0x0159, B:98:0x0161, B:101:0x0166, B:103:0x0170, B:105:0x0174, B:108:0x0180, B:111:0x018b, B:113:0x018f, B:116:0x0197, B:119:0x019c, B:121:0x01a6, B:123:0x01aa, B:124:0x01b3, B:125:0x01b9, B:127:0x01bd, B:130:0x01c5, B:133:0x01ca, B:135:0x01d4, B:137:0x01d8, B:138:0x01e2, B:141:0x01eb, B:143:0x01f6, B:145:0x01fa, B:147:0x0205, B:150:0x023a, B:152:0x024c, B:154:0x0252, B:156:0x0257, B:157:0x025a, B:159:0x0262, B:160:0x0265, B:162:0x0294, B:164:0x029e, B:166:0x02a6, B:167:0x02b0, B:169:0x02b8, B:171:0x02bc, B:173:0x02c0, B:175:0x02cb, B:176:0x02d1, B:180:0x02df, B:183:0x026b, B:184:0x026e, B:186:0x0276, B:188:0x028a, B:189:0x028d, B:190:0x027e, B:192:0x0282, B:196:0x0225, B:208:0x0079), top: B:18:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:19:0x0052, B:24:0x0059, B:26:0x0065, B:32:0x0080, B:33:0x0091, B:34:0x00a1, B:36:0x00a7, B:38:0x00b9, B:41:0x00c1, B:44:0x00c6, B:46:0x00d0, B:48:0x00d4, B:54:0x00e3, B:57:0x00ed, B:59:0x00f1, B:62:0x00f9, B:65:0x00fe, B:67:0x0108, B:69:0x010c, B:72:0x0117, B:75:0x0121, B:77:0x0125, B:80:0x012d, B:83:0x0132, B:85:0x013c, B:87:0x0140, B:90:0x014b, B:93:0x0155, B:95:0x0159, B:98:0x0161, B:101:0x0166, B:103:0x0170, B:105:0x0174, B:108:0x0180, B:111:0x018b, B:113:0x018f, B:116:0x0197, B:119:0x019c, B:121:0x01a6, B:123:0x01aa, B:124:0x01b3, B:125:0x01b9, B:127:0x01bd, B:130:0x01c5, B:133:0x01ca, B:135:0x01d4, B:137:0x01d8, B:138:0x01e2, B:141:0x01eb, B:143:0x01f6, B:145:0x01fa, B:147:0x0205, B:150:0x023a, B:152:0x024c, B:154:0x0252, B:156:0x0257, B:157:0x025a, B:159:0x0262, B:160:0x0265, B:162:0x0294, B:164:0x029e, B:166:0x02a6, B:167:0x02b0, B:169:0x02b8, B:171:0x02bc, B:173:0x02c0, B:175:0x02cb, B:176:0x02d1, B:180:0x02df, B:183:0x026b, B:184:0x026e, B:186:0x0276, B:188:0x028a, B:189:0x028d, B:190:0x027e, B:192:0x0282, B:196:0x0225, B:208:0x0079), top: B:18:0x0052 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(a5.o0 r24, java.lang.Object r25, java.lang.Object r26, java.lang.reflect.Type r27, int r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.v0.j(a5.o0, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}
