package net.typeblog.webview;

import android.content.res.XResources;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XC_MethodHook;
import static de.robv.android.xposed.XposedHelpers.*;

public class ModWebView implements IXposedHookZygoteInit
{

	@Override
	public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable {
		XResources.setSystemWideReplacement("android", "string", "config_webViewPackageName", "com.google.android.webview");
		
		findAndHookMethod("android.webkit.WebViewFactory", null, "getWebViewPackageName", new XC_MethodHook() {
			@Override
			protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
				XposedBridge.log("getWebViewPackageName");
				param.setResult("com.google.android.webview");
			}
		});
	}

}
