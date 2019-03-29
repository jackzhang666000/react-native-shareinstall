//
//  ShareInstallSDK.h
//  SHSmartInstallKit
//
//  Created by smyjw on 2017/11/24.
//  Copyright © 2017年 smyjw. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol ShareInstallDelegate <NSObject>

/**
 * 安装时获取自定义h5页面参数（使用控制中心提供的渠道统计时，渠道编号也会返回给开发者）
 * @ param params 动态参数
 * @ return void
 */
- (void)getInstallParamsFromSmartInstall:(id) params withError: (NSError *) error;


/**
 * 唤醒时获取h5页面参数（如果是渠道链接，渠道编号会一起返回）
 * @ param type 链接类型（区分渠道链接和自定义分享h5链接）
 * @ param params 动态参数
 * @ return void
 */
- (void)getWakeUpParamsFromSmartInstall: (id) params withError: (NSError *) error;

@end

@interface ShareInstallSDK : NSObject
/**
 * 初始化ShareInstall SDK
 * @ param appKey 控制中心创建应用获取appKey
 * @ param launchOptions 该参数存储程序启动的原因
 * @ param delegate 委托方法(getInstallParamsFromSmartInstall和 getWakeUpParamsFromSmartInstall)所在的类的对象
 * @ param launchOptions App 启动参数
 * @ return void
 */
+(void)setAppKey:(NSString *)appKey withDelegate:(id)delegate WithOptions:(NSDictionary *)launchOptions;

/**
 * 处理 URL schemes
 * @ param URL 系统回调传回的URL
 * @ return bool URL是否被ShareInstall识别
 */
+(BOOL)handLinkURL:(NSURL *)URL;

/**
 * 通过 Universal Link 启动应用时会调用 application:(UIApplication *)application continueUserActivity:(NSUserActivity *)userActivity restorationHandler:(void(^)(NSArray * __nullable
 restorableObjects))restorationHandler ,在此方法中调用  [ShareInstallSDK continueUserActivity:userActivity]
 * @ param userActivity 存储了页面信息，包括url
 * @ return bool URL是否被ShareInstall识别
 */
+(BOOL)continueUserActivity:(NSUserActivity*)userActivity;

/**
 * 使用Shareinstall 控制中心提供的渠道统计时，在App用户注册完成后调用，可以统计渠道注册量。
 * @ param
 * @ return void
 */
+(void)reportRegister;
@end
