/*
OVERVIEW
A simple vertical carousel

Slides are cycled through by the two toggles on the right, previous and next. 

Next
=> toggle clicked
=> active slide is faded out, moved up
=> next slide is faded in, moved up

Previous
=> toggle clicked
=> active slide is faded out, moved down
=> next slide is faded in, moved down
*/

$(document).ready(function() {
  
    // slide to start. should always be 1 as it's also the lower bound to the number of slides. corresponds to [pos] attribute on html element
    let active_slide = 1;
    
    // last slide. should be the upper bound to the number of slides. corresponds to [pos] attribute on html element
    let slide_count = 3;
    
    // speed of animations (ms)
    let speed = 250;
    
    
    // hide all slides that aren't starting active slide
    $(".slide[pos!='" + active_slide + "']").each(function() {
      $(this).hide();
    })
    
    
    $(".slide-toggle[direction='next']").click(function() {
      
      
      let next_slide = active_slide + 1;
      
      Next(active_slide, next_slide, slide_count, speed);
      
      // once animations are done, set new active slide
      if (next_slide <= slide_count) {
        active_slide = next_slide;
      } else {
        active_slide = 1;
      }
  
      
    })
    
    
    $(".slide-toggle[direction='prev']").click(function() {
  
      
      let next_slide = active_slide - 1;
      
      Prev(active_slide, next_slide, slide_count, speed);
      
      // once animations are done, set new active slide
      if (next_slide < 1) {
        active_slide = slide_count;
      } else {
        active_slide = next_slide;
      }
      
      
    })
    
    
  })
  
  
  function Next(active_slide, next_slide, slide_count, speed) {
    
  // non active slides moved down so they can slide up when activated
    $(".slide[pos!='" + active_slide + "']").each(function() {
        $(this).css("top", "10px");
      })
    
      
      if (next_slide <= slide_count) {
        
        
        /*   
        Note: delay only works if .hide() or .show() are in its internal queue. Therefore you need to pass an argument to it, even if it's 0. (praise be to stackoverflow)
        */
        
        $(".slide[pos='" + active_slide + "']").animate({opacity:0, top: "-10px"}, {duration: speed}).hide(0).animate({top: "10px"});
        
        $(".slide[pos='" + next_slide + "']").delay(speed).show(0).animate({opacity:1, top: "0px"}, {duration: speed});
        
        $(".index > p").text(next_slide + "/" + slide_count);
  
        
      } else {
        
        next_slide = 1;
          
        $(".slide[pos='" + active_slide + "']").animate({opacity:0, top: "-10px"}, {duration: speed}).hide(0).animate({top: "10px"});
        
        $(".slide[pos='" + next_slide + "']").delay(speed).show(0).animate({opacity: 1, top: "0px"});
        
        $(".index > p").text(next_slide + "/" + slide_count);
        
      }
      
  }
  
  function Prev(active_slide, next_slide, slide_count, speed) {
    
    // non active slides moved up so they can slide down when activated
      $(".slide[pos!='" + active_slide + "']").each(function() {
        $(this).css("top", "-10px");
      })
      
      
      if (next_slide < 1) {
  
        next_slide = slide_count;
        
        $(".slide[pos='" + active_slide + "']").animate({opacity:0, top: "10px"}, {duration: speed}).hide(0).animate({top: "10px"});
        
        $(".slide[pos='" + next_slide + "']").delay(speed).show(0).animate({opacity:1, top: "0px"}, {duration: speed});
        
        $(".index > p").text(next_slide + "/" + slide_count);
        
        
      } else {
       
        
        $(".slide[pos='" + active_slide + "']").animate({opacity:0, top: "10px"}, {duration: speed}).hide(0).animate({top: "10px"});
        
        $(".slide[pos='" + next_slide + "']").delay(speed).show(0).animate({opacity: 1, top: "0px"});
        
        $(".index > p").text(next_slide + "/" + slide_count);
        
        
      }
    
  }