package androidx.datastore.preferences;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8731a = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a(InputStream input) {
            Intrinsics.h(input, "input");
            try {
                d R = d.R(input);
                Intrinsics.g(R, "{\n                Prefer…From(input)\n            }");
                return R;
            } catch (InvalidProtocolBufferException e11) {
                throw new CorruptionException("Unable to parse preferences proto.", e11);
            }
        }
    }
}
