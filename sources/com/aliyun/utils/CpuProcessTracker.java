package com.aliyun.utils;

import android.os.Build;
import android.os.Process;
import com.cicada.player.utils.Logger;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class CpuProcessTracker {
    private static String TAG = "CpuProcessTracker";
    private int mMyPidPercent;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface RuntimeCallback {
        void onLine(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CpuProcessTracker() {
        new Thread(new Runnable() { // from class: com.aliyun.utils.CpuProcessTracker.1
            @Override // java.lang.Runnable
            public void run() {
                CpuProcessTracker.this.updateCpuUsage();
            }
        }).start();
    }

    public static int getCPUCoresNum() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.aliyun.utils.CpuProcessTracker.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private void getCpuUsageAfter25() {
        runtimeExec("top -p " + Process.myPid() + " -o %CPU", new RuntimeCallback() { // from class: com.aliyun.utils.CpuProcessTracker.3
            @Override // com.aliyun.utils.CpuProcessTracker.RuntimeCallback
            public void onLine(String str) {
                try {
                    CpuProcessTracker.this.mMyPidPercent = (int) (Float.parseFloat(str) / CpuProcessTracker.getCPUCoresNum());
                    Logger.v(CpuProcessTracker.TAG, "getCpuUsageAfter25 mMyPidPercent update " + CpuProcessTracker.this.mMyPidPercent);
                } catch (Exception unused) {
                }
            }
        });
    }

    private void getCpuUsageBefore26() {
        runtimeExec(IntegrationConstants.TAB_BAR_POSITION_TOP, new RuntimeCallback() { // from class: com.aliyun.utils.CpuProcessTracker.2
            int cpuValueIndex = -1;

            @Override // com.aliyun.utils.CpuProcessTracker.RuntimeCallback
            public void onLine(String str) {
                LinkedList trim;
                if (!str.contains(Process.myPid() + "") || (trim = CpuProcessTracker.trim(str.split(" "))) == null) {
                    return;
                }
                if (this.cpuValueIndex < 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= trim.size()) {
                            break;
                        }
                        if (((String) trim.get(i11)).contains("%")) {
                            this.cpuValueIndex = i11;
                            break;
                        }
                        i11++;
                    }
                }
                int i12 = this.cpuValueIndex;
                if (i12 < 0) {
                    Logger.v(CpuProcessTracker.TAG, "getCpuUsageBefore26 unknow ");
                    return;
                }
                String str2 = (String) trim.get(i12);
                if (str2.contains("%")) {
                    str2 = str2.substring(0, str2.indexOf("%"));
                }
                try {
                    CpuProcessTracker.this.mMyPidPercent = (int) Float.parseFloat(str2);
                    Logger.v(CpuProcessTracker.TAG, "getCpuUsageBefore26 mMyPidPercent update " + CpuProcessTracker.this.mMyPidPercent);
                } catch (Exception unused) {
                }
            }
        });
    }

    private void runtimeExec(String str, RuntimeCallback runtimeCallback) {
        Process process;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader = null;
        try {
            try {
                process = Runtime.getRuntime().exec(str);
                try {
                    InputStreamReader inputStreamReader2 = new InputStreamReader(process.getInputStream());
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else if (runtimeCallback != null) {
                                    runtimeCallback.onLine(readLine);
                                }
                            } catch (Exception unused) {
                                inputStreamReader = inputStreamReader2;
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (process == null) {
                                    return;
                                }
                                process.destroy();
                            } catch (Throwable th2) {
                                th = th2;
                                inputStreamReader = inputStreamReader2;
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Throwable unused2) {
                                        throw th;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (process != null) {
                                    process.destroy();
                                }
                                throw th;
                            }
                        }
                        inputStreamReader2.close();
                        bufferedReader.close();
                    } catch (Exception unused3) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (Exception unused4) {
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                }
            } catch (Throwable unused5) {
                return;
            }
        } catch (Exception unused6) {
            process = null;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            process = null;
            bufferedReader = null;
        }
        process.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedList<String> trim(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (!strArr[i11].trim().equals("")) {
                linkedList.add(strArr[i11]);
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCpuUsage() {
        if (Build.VERSION.SDK_INT > 25) {
            getCpuUsageAfter25();
        } else {
            getCpuUsageBefore26();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMyPicCpuPercent() {
        Logger.d(TAG, "getMyPicCpuPercent = " + this.mMyPidPercent);
        return this.mMyPidPercent;
    }
}
