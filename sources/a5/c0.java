package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.android.material.timepicker.TimeModel;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import z4.b2;

/* loaded from: classes2.dex */
public class c0 extends z4.b implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f263a = new c0();

    @Override // z4.b2
    public int b() {
        return 2;
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        char[] charArray;
        j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.m0();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == Date.class && !j1Var.q(SerializerFeature.WriteDateUseDateFormat)) {
            if ((((Date) obj).getTime() + o0Var.f379s.getOffset(r9)) % 86400000 == 0 && !SerializerFeature.isEnabled(j1Var.f344c, i11, SerializerFeature.WriteClassName)) {
                j1Var.q0(obj.toString());
                return;
            }
        }
        if (cls == Time.class) {
            long time = ((Time) obj).getTime();
            if ("unixtime".equals(o0Var.o())) {
                j1Var.l0(time / 1000);
                return;
            } else if ("millis".equals(o0Var.o())) {
                j1Var.l0(time);
                return;
            } else if (time < 86400000) {
                j1Var.q0(obj.toString());
                return;
            }
        }
        int nanos = cls == Timestamp.class ? ((Timestamp) obj).getNanos() : 0;
        java.util.Date o11 = obj instanceof java.util.Date ? (java.util.Date) obj : TypeUtils.o(obj);
        if ("unixtime".equals(o0Var.o())) {
            j1Var.l0(o11.getTime() / 1000);
            return;
        }
        if ("millis".equals(o0Var.o())) {
            j1Var.l0(o11.getTime());
            return;
        }
        if (j1Var.q(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat n11 = o0Var.n();
            if (n11 == null) {
                String p11 = o0Var.p();
                if (p11 == null) {
                    p11 = com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(p11, o0Var.f380t);
                simpleDateFormat.setTimeZone(o0Var.f379s);
                n11 = simpleDateFormat;
            }
            j1Var.q0(n11.format(o11));
            return;
        }
        if (j1Var.q(SerializerFeature.WriteClassName) && cls != type) {
            if (cls == java.util.Date.class) {
                j1Var.write("new Date(");
                j1Var.l0(((java.util.Date) obj).getTime());
                j1Var.write(41);
                return;
            } else {
                j1Var.write(Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
                j1Var.w(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY);
                o0Var.B(cls.getName());
                j1Var.V(',', "val", ((java.util.Date) obj).getTime());
                j1Var.write(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
                return;
            }
        }
        long time2 = o11.getTime();
        if (!j1Var.q(SerializerFeature.UseISO8601DateFormat)) {
            j1Var.l0(time2);
            return;
        }
        int i12 = j1Var.q(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        j1Var.write(i12);
        Calendar calendar = Calendar.getInstance(o0Var.f379s, o0Var.f380t);
        calendar.setTimeInMillis(time2);
        int i13 = calendar.get(1);
        int i14 = calendar.get(2) + 1;
        int i15 = calendar.get(5);
        int i16 = calendar.get(11);
        int i17 = calendar.get(12);
        int i18 = calendar.get(13);
        int i19 = calendar.get(14);
        if (nanos > 0) {
            charArray = "0000-00-00 00:00:00.000000000".toCharArray();
            com.alibaba.fastjson.util.f.h(nanos, 29, charArray);
            com.alibaba.fastjson.util.f.h(i18, 19, charArray);
            com.alibaba.fastjson.util.f.h(i17, 16, charArray);
            com.alibaba.fastjson.util.f.h(i16, 13, charArray);
            com.alibaba.fastjson.util.f.h(i15, 10, charArray);
            com.alibaba.fastjson.util.f.h(i14, 7, charArray);
            com.alibaba.fastjson.util.f.h(i13, 4, charArray);
        } else if (i19 != 0) {
            char[] charArray2 = "0000-00-00T00:00:00.000".toCharArray();
            com.alibaba.fastjson.util.f.h(i19, 23, charArray2);
            com.alibaba.fastjson.util.f.h(i18, 19, charArray2);
            com.alibaba.fastjson.util.f.h(i17, 16, charArray2);
            com.alibaba.fastjson.util.f.h(i16, 13, charArray2);
            com.alibaba.fastjson.util.f.h(i15, 10, charArray2);
            com.alibaba.fastjson.util.f.h(i14, 7, charArray2);
            com.alibaba.fastjson.util.f.h(i13, 4, charArray2);
            charArray = charArray2;
        } else if (i18 == 0 && i17 == 0 && i16 == 0) {
            char[] charArray3 = "0000-00-00".toCharArray();
            com.alibaba.fastjson.util.f.h(i15, 10, charArray3);
            com.alibaba.fastjson.util.f.h(i14, 7, charArray3);
            com.alibaba.fastjson.util.f.h(i13, 4, charArray3);
            charArray = charArray3;
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            com.alibaba.fastjson.util.f.h(i18, 19, charArray);
            com.alibaba.fastjson.util.f.h(i17, 16, charArray);
            com.alibaba.fastjson.util.f.h(i16, 13, charArray);
            com.alibaba.fastjson.util.f.h(i15, 10, charArray);
            com.alibaba.fastjson.util.f.h(i14, 7, charArray);
            com.alibaba.fastjson.util.f.h(i13, 4, charArray);
        }
        if (nanos > 0) {
            int i20 = 0;
            while (i20 < 9 && charArray[(charArray.length - i20) - 1] == '0') {
                i20++;
            }
            j1Var.write(charArray, 0, charArray.length - i20);
            j1Var.write(i12);
            return;
        }
        j1Var.write(charArray);
        float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
        int i21 = (int) offset;
        if (i21 == 0.0d) {
            j1Var.write(90);
        } else {
            if (i21 > 9) {
                j1Var.write(43);
                j1Var.h0(i21);
            } else if (i21 > 0) {
                j1Var.write(43);
                j1Var.write(48);
                j1Var.h0(i21);
            } else if (i21 < -9) {
                j1Var.write(45);
                j1Var.h0(-i21);
            } else if (i21 < 0) {
                j1Var.write(45);
                j1Var.write(48);
                j1Var.h0(-i21);
            }
            j1Var.write(58);
            j1Var.append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf((int) (Math.abs(offset - i21) * 60.0f))));
        }
        j1Var.write(i12);
    }

    @Override // z4.b
    public Object f(y4.a aVar, Type type, Object obj, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof java.util.Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return new java.util.Date(TypeUtils.E0((BigDecimal) obj2));
        }
        if (obj2 instanceof Number) {
            return new java.util.Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 23 && str.endsWith(" 000")) {
            str = str.substring(0, 19);
        }
        y4.e eVar = new y4.e(str);
        try {
            if (eVar.x1(false)) {
                Calendar J0 = eVar.J0();
                return type == Calendar.class ? J0 : J0.getTime();
            }
            eVar.close();
            String o11 = aVar.o();
            if (str.length() == o11.length() || ((str.length() == 22 && o11.equals("yyyyMMddHHmmssSSSZ")) || (str.indexOf(84) != -1 && o11.contains("'T'") && str.length() + 2 == o11.length()))) {
                try {
                    return aVar.p().parse(str);
                } catch (ParseException unused) {
                }
            }
            if (str.startsWith("/Date(") && str.endsWith(")/")) {
                str = str.substring(6, str.length() - 2);
            }
            if ("0000-00-00".equals(str) || "0000-00-00T00:00:00".equalsIgnoreCase(str) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str)) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf(Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
            if (lastIndexOf > 20) {
                TimeZone timeZone = TimeZone.getTimeZone(str.substring(lastIndexOf + 1));
                if (!"GMT".equals(timeZone.getID())) {
                    eVar = new y4.e(str.substring(0, lastIndexOf));
                    try {
                        if (eVar.x1(false)) {
                            Calendar J02 = eVar.J0();
                            J02.setTimeZone(timeZone);
                            return type == Calendar.class ? J02 : J02.getTime();
                        }
                    } finally {
                    }
                }
            }
            return new java.util.Date(Long.parseLong(str));
        } finally {
        }
    }
}
