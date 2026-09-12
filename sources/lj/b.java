package lj;

import android.os.Environment;
import com.blankj.utilcode.util.Utils;
import com.transsion.mb.config.manager.ConfigBean;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f68989a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String f68990b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f68991c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f68992d;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.f68992d;
        }

        public final String b() {
            return b.f68990b;
        }

        public final File c() {
            File externalFilesDir = Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            return externalFilesDir == null ? Utils.a().getFilesDir() : externalFilesDir;
        }

        public final int d() {
            Integer v11;
            ConfigBean c11 = sm.f.f75530c.a().c("download_buffer_size", true);
            String value = c11 != null ? c11.getValue() : null;
            if (value == null || value.length() == 0 || (v11 = StringsKt.v(value)) == null) {
                return 8192;
            }
            return v11.intValue();
        }

        public final String e() {
            File externalFilesDir = Utils.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            if (externalFilesDir == null && (externalFilesDir = Utils.a().getFilesDir()) == null) {
                externalFilesDir = Utils.a().getCacheDir();
            }
            return externalFilesDir.getAbsolutePath() + File.separatorChar + "d";
        }

        public final String f() {
            return b.f68991c;
        }
    }

    static {
        String str = Environment.DIRECTORY_DCIM;
        String str2 = File.separator;
        f68990b = str + str2 + "MovieBox";
        f68991c = Environment.DIRECTORY_DOWNLOADS + str2 + "MovieBox";
        f68992d = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + Environment.DIRECTORY_DCIM + str2 + "MovieBox";
    }
}
