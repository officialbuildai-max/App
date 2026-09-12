package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;

/* loaded from: classes7.dex */
public final class JsonTreeReader {

    /* renamed from: a, reason: collision with root package name */
    private final a f68406a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f68407b;

    /* renamed from: c, reason: collision with root package name */
    private int f68408c;

    public JsonTreeReader(kotlinx.serialization.json.f configuration, a lexer) {
        Intrinsics.h(configuration, "configuration");
        Intrinsics.h(lexer, "lexer");
        this.f68406a = lexer;
        this.f68407b = configuration.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.serialization.json.h f() {
        int i11;
        byte m11 = this.f68406a.m();
        if (this.f68406a.E() == 4) {
            a.y(this.f68406a, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.f68406a.f()) {
            arrayList.add(e());
            m11 = this.f68406a.m();
            if (m11 != 4) {
                a aVar = this.f68406a;
                boolean z10 = m11 == 9;
                i11 = aVar.f68409a;
                if (!z10) {
                    a.y(aVar, "Expected end of the array or comma", i11, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (m11 == 8) {
            this.f68406a.n((byte) 9);
        } else if (m11 == 4) {
            a.y(this.f68406a, "Unexpected trailing comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return new kotlinx.serialization.json.b(arrayList);
    }

    private final kotlinx.serialization.json.h g() {
        return (kotlinx.serialization.json.h) DeepRecursiveKt.b(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.f67184a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0096 -> B:10:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(kotlin.DeepRecursiveScope r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.h(kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final kotlinx.serialization.json.h i() {
        byte n11 = this.f68406a.n((byte) 6);
        if (this.f68406a.E() == 4) {
            a.y(this.f68406a, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.f68406a.f()) {
                break;
            }
            String s11 = this.f68407b ? this.f68406a.s() : this.f68406a.q();
            this.f68406a.n((byte) 5);
            linkedHashMap.put(s11, e());
            n11 = this.f68406a.m();
            if (n11 != 4) {
                if (n11 != 7) {
                    a.y(this.f68406a, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (n11 == 6) {
            this.f68406a.n((byte) 7);
        } else if (n11 == 4) {
            a.y(this.f68406a, "Unexpected trailing comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.serialization.json.u j(boolean z10) {
        String s11 = (this.f68407b || !z10) ? this.f68406a.s() : this.f68406a.q();
        return (z10 || !Intrinsics.c(s11, "null")) ? new kotlinx.serialization.json.o(s11, z10) : JsonNull.f68349c;
    }

    public final kotlinx.serialization.json.h e() {
        byte E = this.f68406a.E();
        if (E == 1) {
            return j(true);
        }
        if (E == 0) {
            return j(false);
        }
        if (E == 6) {
            int i11 = this.f68408c + 1;
            this.f68408c = i11;
            this.f68408c--;
            return i11 == 200 ? g() : i();
        }
        if (E == 8) {
            return f();
        }
        a.y(this.f68406a, "Cannot begin reading element, unexpected token: " + ((int) E), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }
}
