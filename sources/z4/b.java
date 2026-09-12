package z4;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class b extends e implements b2 {
    @Override // z4.e, z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        return e(aVar, type, obj, null, 0);
    }

    @Override // z4.e
    public Object e(y4.a aVar, Type type, Object obj, String str, int i11) {
        Object T;
        SimpleDateFormat simpleDateFormat;
        Date date;
        SimpleDateFormat simpleDateFormat2;
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() == 2) {
            long l11 = bVar.l();
            bVar.c0(16);
            if ("unixtime".equals(str)) {
                l11 *= 1000;
            }
            T = Long.valueOf(l11);
        } else {
            Date date2 = null;
            if (bVar.q0() == 4) {
                String k02 = bVar.k0();
                if (str != null) {
                    if ("yyyy-MM-dd HH:mm:ss.SSSSSSSSS".equals(str) && (type instanceof Class) && ((Class) type).getName().equals("java.sql.Timestamp")) {
                        return TypeUtils.B(k02);
                    }
                    try {
                        simpleDateFormat = new SimpleDateFormat(str, aVar.f78954f.B0());
                    } catch (IllegalArgumentException e11) {
                        if (str.contains("T")) {
                            try {
                                simpleDateFormat = new SimpleDateFormat(str.replaceAll("T", "'T'"), aVar.f78954f.B0());
                            } catch (IllegalArgumentException unused) {
                                throw e11;
                            }
                        } else {
                            simpleDateFormat = null;
                        }
                    }
                    if (com.alibaba.fastjson.a.defaultTimeZone != null) {
                        simpleDateFormat.setTimeZone(aVar.f78954f.l0());
                    }
                    try {
                        date = simpleDateFormat.parse(k02);
                    } catch (ParseException unused2) {
                        date = null;
                    }
                    if (date == null && com.alibaba.fastjson.a.defaultLocale == Locale.CHINA) {
                        try {
                            simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
                        } catch (IllegalArgumentException e12) {
                            simpleDateFormat2 = simpleDateFormat;
                            if (str.contains("T")) {
                                try {
                                    simpleDateFormat2 = new SimpleDateFormat(str.replaceAll("T", "'T'"), aVar.f78954f.B0());
                                } catch (IllegalArgumentException unused3) {
                                    throw e12;
                                }
                            }
                        }
                        simpleDateFormat2.setTimeZone(aVar.f78954f.l0());
                        try {
                            date = simpleDateFormat2.parse(k02);
                        } catch (ParseException unused4) {
                            date = null;
                        }
                    }
                    if (date != null) {
                        date2 = date;
                    } else if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && k02.length() == 19) {
                        try {
                            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", com.alibaba.fastjson.a.defaultLocale);
                            simpleDateFormat3.setTimeZone(com.alibaba.fastjson.a.defaultTimeZone);
                            date2 = simpleDateFormat3.parse(k02);
                        } catch (ParseException unused5) {
                        }
                    }
                }
                if (date2 == null) {
                    bVar.c0(16);
                    Object obj2 = k02;
                    if (bVar.n(Feature.AllowISO8601DateFormat)) {
                        y4.e eVar = new y4.e(k02);
                        Object obj3 = k02;
                        if (eVar.w1()) {
                            obj3 = eVar.J0().getTime();
                        }
                        eVar.close();
                        obj2 = obj3;
                    }
                    T = obj2;
                }
                T = date2;
            } else if (bVar.q0() == 8) {
                bVar.Z();
                T = date2;
            } else if (bVar.q0() == 12) {
                bVar.Z();
                if (bVar.q0() != 4) {
                    throw new JSONException("syntax error");
                }
                if (com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(bVar.k0())) {
                    bVar.Z();
                    aVar.b(17);
                    Class j11 = aVar.m().j(bVar.k0(), null, bVar.r());
                    if (j11 != null) {
                        type = j11;
                    }
                    aVar.b(4);
                    aVar.b(16);
                }
                bVar.q(2);
                if (bVar.q0() != 2) {
                    throw new JSONException("syntax error : " + bVar.v());
                }
                long l12 = bVar.l();
                bVar.Z();
                T = Long.valueOf(l12);
                aVar.b(13);
            } else if (aVar.u() == 2) {
                aVar.E0(0);
                aVar.b(16);
                if (bVar.q0() != 4) {
                    throw new JSONException("syntax error");
                }
                if (!"val".equals(bVar.k0())) {
                    throw new JSONException("syntax error");
                }
                bVar.Z();
                aVar.b(17);
                T = aVar.T();
                aVar.b(13);
            } else {
                T = aVar.T();
            }
        }
        return f(aVar, type, obj, T);
    }

    protected abstract Object f(y4.a aVar, Type type, Object obj, Object obj2);
}
