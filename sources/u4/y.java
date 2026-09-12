package u4;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes2.dex */
abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final JsonReader.a f76806a = JsonReader.a.a("nm", "mm", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths a(JsonReader jsonReader) {
        String str = null;
        boolean z10 = false;
        MergePaths.MergePathsMode mergePathsMode = null;
        while (jsonReader.m()) {
            int v11 = jsonReader.v(f76806a);
            if (v11 == 0) {
                str = jsonReader.r();
            } else if (v11 == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.p());
            } else if (v11 != 2) {
                jsonReader.w();
                jsonReader.x();
            } else {
                z10 = jsonReader.n();
            }
        }
        return new MergePaths(str, mergePathsMode, z10);
    }
}
