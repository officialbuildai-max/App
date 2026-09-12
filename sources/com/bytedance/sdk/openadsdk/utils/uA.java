package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class uA {

    /* renamed from: com.bytedance.sdk.openadsdk.utils.uA$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static class AnonymousClass1 implements FilenameFilter {
        private final Pattern Sj = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass1() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.Sj.matcher(str).matches();
        }
    }

    public static int Sj() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    public static int Sj(int i11) {
        BufferedReader bufferedReader;
        Throwable th2;
        BufferedReader bufferedReader2;
        int parseInt;
        int i12 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader3 = null;
        while (true) {
            i11--;
            if (i11 < 0) {
                return i12;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i11 + "/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader2 = new BufferedReader(fileReader2);
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader3;
                    th2 = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!TextUtils.isEmpty(readLine) && (parseInt = Integer.parseInt(readLine)) > i12) {
                        i12 = parseInt;
                    }
                    try {
                        bufferedReader2.close();
                        fileReader2.close();
                    } catch (Exception unused) {
                    }
                    bufferedReader3 = bufferedReader2;
                    fileReader = fileReader2;
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedReader = bufferedReader2;
                    fileReader = fileReader2;
                    try {
                        com.bytedance.sdk.component.utils.sU.sP("CpuUtils", th2.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                                bufferedReader3 = bufferedReader;
                            }
                        }
                        bufferedReader3 = bufferedReader;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                    }
                }
            } catch (Throwable th5) {
                bufferedReader = bufferedReader3;
                th2 = th5;
            }
        }
    }

    public static int Sj(Context context) {
        return com.bytedance.sdk.openadsdk.core.TKC.Sj(context).sP("cpu_count", 0);
    }

    public static int TKC(Context context) {
        return com.bytedance.sdk.openadsdk.core.TKC.Sj(context).sP("cpu_min_frequency", 0);
    }

    public static int sP(int i11) {
        BufferedReader bufferedReader;
        Throwable th2;
        BufferedReader bufferedReader2;
        int parseInt;
        int i12 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader3 = null;
        while (true) {
            i11--;
            if (i11 < 0) {
                return i12;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i11 + "/cpufreq/cpuinfo_min_freq");
                try {
                    bufferedReader2 = new BufferedReader(fileReader2);
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader3;
                    th2 = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!TextUtils.isEmpty(readLine) && ((parseInt = Integer.parseInt(readLine)) < i12 || i12 == 0)) {
                        i12 = parseInt;
                    }
                    try {
                        bufferedReader2.close();
                        fileReader2.close();
                    } catch (Exception unused) {
                    }
                    bufferedReader3 = bufferedReader2;
                    fileReader = fileReader2;
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedReader = bufferedReader2;
                    fileReader = fileReader2;
                    try {
                        com.bytedance.sdk.component.utils.sU.sP("CpuUtils", th2.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                                bufferedReader3 = bufferedReader;
                            }
                        }
                        bufferedReader3 = bufferedReader;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                    }
                }
            } catch (Throwable th5) {
                bufferedReader = bufferedReader3;
                th2 = th5;
            }
        }
    }

    public static int sP(Context context) {
        return com.bytedance.sdk.openadsdk.core.TKC.Sj(context).sP("cpu_max_frequency", 0);
    }
}
