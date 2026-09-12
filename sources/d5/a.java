package d5;

import a5.j1;
import a5.o0;
import a5.z0;
import com.alibaba.fastjson.JSONObject;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.money.Monetary;
import org.javamoney.moneta.Money;
import z4.b2;

/* loaded from: classes3.dex */
public class a implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f61356a = new a();

    @Override // z4.b2
    public int b() {
        return 0;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        JSONObject l02 = aVar.l0();
        Object obj2 = l02.get("currency");
        String string = obj2 instanceof JSONObject ? ((JSONObject) obj2).getString("currencyCode") : obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = l02.get("numberStripped");
        if ((obj3 instanceof BigDecimal) || (obj3 instanceof Integer) || (obj3 instanceof BigInteger)) {
            return Money.of((Number) obj3, Monetary.getCurrency(string, new String[0]));
        }
        throw new UnsupportedOperationException();
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        Money money = (Money) obj;
        if (money == null) {
            o0Var.C();
            return;
        }
        j1 j1Var = o0Var.f371k;
        j1Var.a0('{', "numberStripped", money.getNumberStripped());
        j1Var.Z(',', "currency", money.getCurrency().getCurrencyCode());
        j1Var.write(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
    }
}
