package ug;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.k;

/* loaded from: classes3.dex */
public class c implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Type f76872a;

    /* renamed from: b, reason: collision with root package name */
    private final String f76873b;

    /* renamed from: d, reason: collision with root package name */
    private final String f76875d = "{\"code\":200005,\"data\":{},\"msg\":\"unknown error\"}";

    /* renamed from: c, reason: collision with root package name */
    private Gson f76874c = new Gson();

    public c(Type type, String str) {
        this.f76872a = type;
        this.f76873b = str;
    }

    @Override // retrofit2.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object convert(ResponseBody responseBody) {
        BufferedSource buffer = Okio.buffer(responseBody.getSource());
        String readUtf8 = buffer.readUtf8();
        lg.a.f68962a.c("HttpTag", "Converter origin json:" + readUtf8, false);
        buffer.close();
        if (TextUtils.equals(this.f76873b, "1311")) {
            return readUtf8;
        }
        try {
            return o.e(readUtf8, this.f76872a);
        } catch (JsonSyntaxException e11) {
            lg.a.f68962a.i("HttpTag", "error =" + e11.getMessage() + "json= " + readUtf8, true);
            return this.f76874c.fromJson(readUtf8, this.f76872a);
        }
    }
}
