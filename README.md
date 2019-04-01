
# react-native-shareinstall

## Getting started

`$ npm install react-native-shareinstall --save`

### Mostly automatic installation

`$ react-native link react-native-shareinstall`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-shareinstall` and add `RNShareinstall.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNShareinstall.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<
5.ios 功能暂且还没完善，后续会更新，2.0版本会更新完整iOS功能

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNShareinstallPackage;` to the imports at the top of the file
  - Add `new RNShareinstallPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-shareinstall'
  	project(':react-native-shareinstall').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-shareinstall/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-shareinstall')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNShareinstall.sln` in `node_modules/react-native-shareinstall/windows/RNShareinstall.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Shareinstall.RNShareinstall;` to the usings at the top of the file
  - Add `new RNShareinstallPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNShareinstallModule from 'react-native-shareinstall';

  #该方法用于监听app通过univeral link或scheme拉起后获取唤醒参数
    this.receiveWakeupListener = map => {
       if (map) {
         //do your work here
       }        
     Alert.alert('拉起回调',JSON.stringify(map)) 
    } 
		RNShareinstallModule.addWakeUpListener(this.receiveWakeupListener) 
		
#该方法用于获取安装参数
 RNShareinstallModule.getInstall(10, map => {
      if (map) {
        //do your work here
      }        
      Alert.alert('安装回调',JSON.stringify(map))     
    })
```

  