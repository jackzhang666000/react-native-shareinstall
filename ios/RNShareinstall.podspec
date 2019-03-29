
Pod::Spec.new do |s|
  s.name         = "RNShareinstall"
  s.version      = "1.0.0"
  s.summary      = "RNShareinstall"
  s.description  = <<-DESC
                  RNShareinstall
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNShareinstall.git", :tag => "master" }
  s.source_files  = "RNShareinstall/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  