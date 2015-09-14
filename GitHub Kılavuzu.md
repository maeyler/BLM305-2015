## GitHub Kılavuzu

GitHub kullanmak için üç önemli sebep:
* Yazdığınız ve kullandığınız kod merkezde dursun, her yerden erişilebilsin
* Otomatik sürüm kontrolü ve koordineli takım çalışması imkanı
* Programcılar için özgeçmişin önemli bir parçası

Git'in akış ve dallanma mantığını anlamak için iyi bir başlangıç [burada](https://guides.github.com/introduction/flow/)

### GitHub Desktop

Mac ve Windows için yazılmış bu program ile Git kullanmak çok kolaylaştı

Öncelikle [GitHub hesabı açmak](https://github.com/join) ve [Desktop programını kurmak](https://desktop.github.com) gerekiyor

Örnek olarak eski bir projemizi GitHub'a koyalım:
* Klasörü programın açık penceresine sürükleyin, güzel bir isim verin
* "Uncommitted Changes" üstünde tıklayın, yeni bir isim ile `Commit` düğmesine basın
* `Publish` düğmesine basarak kendi GitHub hesabınıza ekleyin

İşimiz üç adımda bitti, projemiz hem yerel diskte hem de GitHub repository'de duruyor
* Bunlardan biri değişince, `Sync` düğmesine basmak gerekiyor  **<-- Bu adım otomatik değil**

### Git CLI

Desktop programı öncesinde, bu adımları *Command line* içinde lokal klasör altında `git` komutu ile yapmak gerekiyordu

Her işleme karşı gelen `git` komutu ile sürecin ne kadar basitleştiğini görebilirsiniz:
* Klasörü programın açık penceresine sürükleyin   `git init`
* "Uncommitted Changes" üstünde tıklayın   `git add *` (tam bunu yapmıyor)
* ... yeni bir isim ile `Commit` düğmesine basın  `git commit -m "yeni bir isim"`
* `git remote add origin https://github.com/maeyler/xxx.git` (remote repo'yu tanıtmak için)
* `Publish` düğmesine basarak kendi GitHub hesabınıza ekleyin  `git push origin master`
* `Sync` düğmesine basmek gerekiyor   `git push origin master; git pull`

Git için [kısa bir özet](http://try.github.io) ve [kapsamlı bir kitap](https://git-scm.com/book/en/v2) var 
ama Desktop programı normal bir kullanıcının bütün ihtiyacını karşılıyor

### Referanslar

* forvo.com/word/github/
* en.wikipedia.org/wiki/Git_(software)
* github.com
* desktop.github.com
* guides.github.com
* guides.github.com/introduction/flow
* guides.github.com/introduction/getting-your-project-on-github
* try.github.io

