package a5;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import z4.b2;

/* loaded from: classes2.dex */
public class q0 implements z0, a0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final q0 f392a = new q0();

    /* renamed from: b, reason: collision with root package name */
    private static final DateTimeFormatter f393b = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    /* renamed from: c, reason: collision with root package name */
    private static final DateTimeFormatter f394c = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /* renamed from: d, reason: collision with root package name */
    private static final DateTimeFormatter f395d = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");

    /* renamed from: e, reason: collision with root package name */
    private static final DateTimeFormatter f396e = DateTimeFormat.forPattern("yyyy年M月d日 HH:mm:ss");

    /* renamed from: f, reason: collision with root package name */
    private static final DateTimeFormatter f397f = DateTimeFormat.forPattern("yyyy年M月d日 H时m分s秒");

    /* renamed from: g, reason: collision with root package name */
    private static final DateTimeFormatter f398g = DateTimeFormat.forPattern("yyyy년M월d일 HH:mm:ss");

    /* renamed from: h, reason: collision with root package name */
    private static final DateTimeFormatter f399h = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");

    /* renamed from: i, reason: collision with root package name */
    private static final DateTimeFormatter f400i = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

    /* renamed from: j, reason: collision with root package name */
    private static final DateTimeFormatter f401j = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");

    /* renamed from: k, reason: collision with root package name */
    private static final DateTimeFormatter f402k = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");

    /* renamed from: l, reason: collision with root package name */
    private static final DateTimeFormatter f403l = DateTimeFormat.forPattern("yyyyMMdd");

    /* renamed from: m, reason: collision with root package name */
    private static final DateTimeFormatter f404m = DateTimeFormat.forPattern("yyyy/MM/dd");

    /* renamed from: n, reason: collision with root package name */
    private static final DateTimeFormatter f405n = DateTimeFormat.forPattern("yyyy年M月d日");

    /* renamed from: o, reason: collision with root package name */
    private static final DateTimeFormatter f406o = DateTimeFormat.forPattern("yyyy년M월d일");

    /* renamed from: p, reason: collision with root package name */
    private static final DateTimeFormatter f407p = DateTimeFormat.forPattern("MM/dd/yyyy");

    /* renamed from: q, reason: collision with root package name */
    private static final DateTimeFormatter f408q = DateTimeFormat.forPattern("dd/MM/yyyy");

    /* renamed from: r, reason: collision with root package name */
    private static final DateTimeFormatter f409r = DateTimeFormat.forPattern("dd.MM.yyyy");

    /* renamed from: s, reason: collision with root package name */
    private static final DateTimeFormatter f410s = DateTimeFormat.forPattern("dd-MM-yyyy");

    /* renamed from: t, reason: collision with root package name */
    private static final DateTimeFormatter f411t = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withZone(DateTimeZone.getDefault());

    /* renamed from: u, reason: collision with root package name */
    private static final DateTimeFormatter f412u = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

    private void i(j1 j1Var, ReadablePartial readablePartial, String str) {
        j1Var.q0((str.equals("yyyy-MM-dd'T'HH:mm:ss") ? f412u : DateTimeFormat.forPattern(str)).print(readablePartial));
    }

    @Override // a5.a0
    public void a(o0 o0Var, Object obj, p pVar) {
        i(o0Var.f371k, (ReadablePartial) obj, pVar.b());
    }

    @Override // z4.b2
    public int b() {
        return 4;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        return e(aVar, type, obj, null, 0);
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.m0();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != LocalDateTime.class) {
            j1Var.q0(obj.toString());
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
        int mask = serializerFeature.getMask();
        LocalDateTime localDateTime = (LocalDateTime) obj;
        String o11 = o0Var.o();
        if (o11 == null) {
            o11 = ((i11 & mask) != 0 || o0Var.t(serializerFeature)) ? "yyyy-MM-dd'T'HH:mm:ss" : o0Var.t(SerializerFeature.WriteDateUseDateFormat) ? com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT : localDateTime.getMillisOfSecond() == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
        }
        if (o11 != null) {
            i(j1Var, localDateTime, o11);
        } else {
            j1Var.l0(localDateTime.toDateTime(DateTimeZone.forTimeZone(com.alibaba.fastjson.a.defaultTimeZone)).toInstant().getMillis());
        }
    }

    public Object e(y4.a aVar, Type type, Object obj, String str, int i11) {
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() == 8) {
            bVar.Z();
            return null;
        }
        if (bVar.q0() == 4) {
            String k02 = bVar.k0();
            bVar.Z();
            DateTimeFormatter forPattern = str != null ? "yyyy-MM-dd HH:mm:ss".equals(str) ? f393b : DateTimeFormat.forPattern(str) : null;
            if ("".equals(k02)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                return (k02.length() == 10 || k02.length() == 8) ? g(k02, str, forPattern).toLocalDateTime(LocalTime.MIDNIGHT) : f(k02, forPattern);
            }
            if (type == LocalDate.class) {
                return k02.length() == 23 ? LocalDateTime.parse(k02).toLocalDate() : g(k02, str, forPattern);
            }
            if (type == LocalTime.class) {
                return k02.length() == 23 ? LocalDateTime.parse(k02).toLocalTime() : LocalTime.parse(k02);
            }
            if (type == DateTime.class) {
                if (forPattern == f393b) {
                    forPattern = f411t;
                }
                return h(k02, forPattern);
            }
            if (type == DateTimeZone.class) {
                return DateTimeZone.forID(k02);
            }
            if (type == Period.class) {
                return Period.parse(k02);
            }
            if (type == Duration.class) {
                return Duration.parse(k02);
            }
            if (type == Instant.class) {
                int i12 = 0;
                while (true) {
                    if (i12 < k02.length()) {
                        char charAt = k02.charAt(i12);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i12++;
                    } else if (k02.length() > 8 && k02.length() < 19) {
                        return new Instant(Long.parseLong(k02));
                    }
                }
                return Instant.parse(k02);
            }
            if (type == DateTimeFormatter.class) {
                return DateTimeFormat.forPattern(k02);
            }
        } else {
            if (bVar.q0() == 2) {
                long l11 = bVar.l();
                bVar.Z();
                TimeZone timeZone = com.alibaba.fastjson.a.defaultTimeZone;
                if (timeZone == null) {
                    timeZone = TimeZone.getDefault();
                }
                if (type == DateTime.class) {
                    return new DateTime(l11, DateTimeZone.forTimeZone(timeZone));
                }
                LocalDateTime localDateTime = new LocalDateTime(l11, DateTimeZone.forTimeZone(timeZone));
                if (type == LocalDateTime.class) {
                    return localDateTime;
                }
                if (type == LocalDate.class) {
                    return localDateTime.toLocalDate();
                }
                if (type == LocalTime.class) {
                    return localDateTime.toLocalTime();
                }
                if (type == Instant.class) {
                    return new Instant(l11);
                }
                throw new UnsupportedOperationException();
            }
            if (bVar.q0() != 12) {
                throw new UnsupportedOperationException();
            }
            JSONObject l02 = aVar.l0();
            if (type == Instant.class) {
                Object obj2 = l02.get("epochSecond");
                if (obj2 instanceof Number) {
                    return Instant.ofEpochSecond(TypeUtils.D0((Number) obj2));
                }
                Object obj3 = l02.get("millis");
                if (obj3 instanceof Number) {
                    return Instant.ofEpochMilli(TypeUtils.D0((Number) obj3));
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0128 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected org.joda.time.LocalDateTime f(java.lang.String r17, org.joda.time.format.DateTimeFormatter r18) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.q0.f(java.lang.String, org.joda.time.format.DateTimeFormatter):org.joda.time.LocalDateTime");
    }

    protected LocalDate g(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f403l;
            }
            int i11 = 0;
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = f404m;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i12 = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter3 = f408q;
                    } else if (i12 > 12) {
                        dateTimeFormatter3 = f407p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = f407p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = f408q;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (charAt5 == '.' && charAt7 == '.') {
                    dateTimeFormatter = f409r;
                } else if (charAt5 == '-' && charAt7 == '-') {
                    dateTimeFormatter = f410s;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter2 = f405n;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter2 = f406o;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            while (true) {
                if (i11 < str.length()) {
                    char charAt9 = str.charAt(i11);
                    if (charAt9 < '0' || charAt9 > '9') {
                        break;
                    }
                    i11++;
                } else if (str.length() > 8 && str.length() < 19) {
                    return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(com.alibaba.fastjson.a.defaultTimeZone)).toLocalDate();
                }
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    protected DateTime h(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = f412u;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = f393b;
                        }
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = f395d;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i11 = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = f400i;
                            } else if (i11 > 12) {
                                dateTimeFormatter = f399h;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f399h;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f400i;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = f401j;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = f402k;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    dateTimeFormatter = str.charAt(str.length() - 1) == 31186 ? f397f : f396e;
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = f398g;
                }
            }
        }
        return dateTimeFormatter == null ? DateTime.parse(str) : DateTime.parse(str, dateTimeFormatter);
    }
}
