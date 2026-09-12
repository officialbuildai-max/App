package z4;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;

/* loaded from: classes3.dex */
public class l3 implements b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final l3 f79368a = new l3();

    @Override // z4.b2
    public int b() {
        return 2;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        long parseLong;
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() == 16) {
            bVar.c0(4);
            if (bVar.q0() != 4) {
                throw new JSONException("syntax error");
            }
            bVar.q(2);
            if (bVar.q0() != 2) {
                throw new JSONException("syntax error");
            }
            long l11 = bVar.l();
            bVar.c0(13);
            if (bVar.q0() != 13) {
                throw new JSONException("syntax error");
            }
            bVar.c0(16);
            return new Time(l11);
        }
        Object T = aVar.T();
        if (T == null) {
            return null;
        }
        if (T instanceof Time) {
            return T;
        }
        if (T instanceof BigDecimal) {
            return new Time(TypeUtils.E0((BigDecimal) T));
        }
        if (T instanceof Number) {
            return new Time(((Number) T).longValue());
        }
        if (!(T instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) T;
        if (str.length() == 0) {
            return null;
        }
        y4.e eVar = new y4.e(str);
        if (eVar.w1()) {
            parseLong = eVar.J0().getTimeInMillis();
        } else {
            for (int i11 = 0; i11 < str.length(); i11++) {
                char charAt = str.charAt(i11);
                if (charAt < '0' || charAt > '9') {
                    eVar.close();
                    return Time.valueOf(str);
                }
            }
            parseLong = Long.parseLong(str);
        }
        eVar.close();
        return new Time(parseLong);
    }
}
