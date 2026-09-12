package bw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Gson f17020a;

    static {
        Gson create = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Intrinsics.g(create, "create(...)");
        f17020a = create;
    }
}
