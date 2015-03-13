gulp = require 'gulp'
coffee = require 'gulp-coffee'

paths =
  src:
    coffee: ['src/main/coffee/**/*.coffee']
  dst:
    coffee: 'build/generated-resources/META-INF/modules'

gulp.task 'build', ['coffee']

gulp.task 'coffee', (done) ->
  gulp.src paths.src.coffee
  .pipe coffee()
  .pipe gulp.dest paths.dst.coffee
  .on 'end', done
  return

gulp.task 'watch', ['coffee'], () ->
  gulp.watch paths.coffee, ['coffee']
  return
