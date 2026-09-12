package ug;

import com.alibaba.fastjson.serializer.SerializerFeature;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.k;

/* loaded from: classes3.dex */
public class b implements k {

    /* renamed from: a, reason: collision with root package name */
    private static final MediaType f76871a = MediaType.parse("application/json; charset=UTF-8");

    @Override // retrofit2.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RequestBody convert(Object obj) {
        return RequestBody.create(f76871a, com.alibaba.fastjson.a.toJSONBytes(obj, new SerializerFeature[0]));
    }
}
