angular.module('starter.controllers', [])

.controller('SignInCtrl', function ($scope, $state, $ionicLoading, User) {
  $scope.signIn = function (user) {
    $ionicLoading.show({
      template: 'Loading...'
    });

    User.signIn(user).then(function (user) {
      $ionicLoading.hide();
      $state.go('tab.dash');
    }, function (err) {
      $ionicLoading.hide();
      alert(err);
    });
  };
})

.controller('DashCtrl', function ($scope, $ionicPopover, User, Camera) {
  $scope.messages = 120;

  $scope.bills = User.bills();

  $scope.recentBills = _($scope.bills)
                          .sortBy(function (bill) {
                            return bill.total;
                          })
                          .first(5)
                          .value();

  $scope.totalExpenses = User.totalExpenses();

  $scope.cashLeft = User.cashLeft();

  $ionicPopover.fromTemplateUrl('templates/dialog-new-bill-method.html', {
    scope: $scope,
  }).then(function (popover) {
    $scope.popover = popover;
  });

  $scope.addNewBill = function ($event) {
    $scope.popover.show($event);
  };

  $scope.fromGallery = function () {
    // Refer to: http://docs.phonegap.com/en/edge/cordova_camera_camera.md.html#cameraOptions
    var options = {
      destinationType: navigator.camera.DestinationType.DATA_URL,
      sourceType : navigator.camera.PictureSourceType.PHOTOLIBRARY
    };
    Camera.getPicture(options).then(function (imageURI) {
      $scope.imageUri = "data:image/jpeg;base64," + imageURI;
    }, function (err) {
      alert(err);
    });
  };

  $scope.fromCamera = function () {
    // Refer to: http://docs.phonegap.com/en/edge/cordova_camera_camera.md.html#cameraOptions
    var options = {
    };
    Camera.getPicture(options).then(function (imageURI) {
      $scope.imageUri = imageURI;
    }, function (err) {
      alert(err);
    });
  };
})

.controller('ExpensesCtrl', function ($scope, Chats) {
  $scope.chats = Chats.all();
  $scope.remove = function(chat) {
    Chats.remove(chat);
  }
})

.controller('ChatDetailCtrl', function ($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('FriendsCtrl', function ($scope, Friends) {
  $scope.friends = Friends.all();
})

.controller('FriendDetailCtrl', function ($scope, $stateParams, Friends) {
  $scope.friend = Friends.get($stateParams.friendId);
})

.controller('SettingsCtrl', function ($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
