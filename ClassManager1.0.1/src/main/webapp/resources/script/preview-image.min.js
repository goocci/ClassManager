var gallery = (function(){
  'use strict';
  return {
    // this.js(obj)
    js: function(e){return $("[data-js="+e+"]");},
    // this.lk(obj)
    lk: function(e){return $("[data-lk="+e+"]");},
    // Ready functions
    ready_: function(){this.events();},
    //  functions
    events:function(){
      var self = this;
      var close = $('.gallery_item_full');
      close.append('<a href="#" data-js="cl" class="cl">X</a>');
      // Get all data js and add clickOn function
      var k = $('a[data-js]');
      k.each(function(i, v){
        i = i+1;
        self.clickOn(i);
      });
      // close on click
      self.js('cl').on("click",function(){
        self.fx_out($('.gallery_item_full'));
        self.fx_out($('.box'));
      });
      
      // list
      self.js('list').on("click",function(){
        $('.gallery_item').toggleClass('gallery_item_list');
        $('.gallery_item_preview a img').toggleClass('gallery_line');
      });
    },
    // Show on click
    clickOn: function(i){
      var self = this;
      this.js(i).on('click',function(){
        self.fx_in(self.lk(i)); 
        self.fx_in($('.box'));
      });
    }, 
    // out function
    fx_out: function(el){
      el.addClass('efOut')
      .delay(500)
      .fadeOut('fast')
      .removeClass('efIn');
      $('body').css({overflow:'auto'});
      return false;
    }, 
    // in function
    fx_in: function(el){
      el.removeClass('efOut')
      .show()
      .addClass('efIn');
      $('body').css({overflow:'hidden'});
      return false;
    }
  };
})();
// ready function of gallery
gallery.ready_();