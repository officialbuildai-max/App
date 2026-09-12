package n0;

import android.os.LocaleList;
import android.util.Log;
import androidx.compose.ui.text.platform.o;
import androidx.compose.ui.text.platform.p;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class e implements j {

    /* renamed from: a, reason: collision with root package name */
    private LocaleList f70178a;

    /* renamed from: b, reason: collision with root package name */
    private i f70179b;

    /* renamed from: c, reason: collision with root package name */
    private final p f70180c = o.a();

    @Override // n0.j
    public Locale a(String str) {
        String str2;
        Locale forLanguageTag = Locale.forLanguageTag(str);
        if (Intrinsics.c(forLanguageTag.toLanguageTag(), C.LANGUAGE_UNDETERMINED)) {
            str2 = f.f70181a;
            Log.e(str2, "The language tag " + str + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
        }
        return forLanguageTag;
    }

    @Override // n0.j
    public i d() {
        LocaleList localeList;
        int size;
        Locale locale;
        localeList = LocaleList.getDefault();
        synchronized (this.f70180c) {
            i iVar = this.f70179b;
            if (iVar != null && localeList == this.f70178a) {
                return iVar;
            }
            size = localeList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i11 = 0; i11 < size; i11++) {
                locale = localeList.get(i11);
                arrayList.add(new h(locale));
            }
            i iVar2 = new i(arrayList);
            this.f70178a = localeList;
            this.f70179b = iVar2;
            return iVar2;
        }
    }
}
